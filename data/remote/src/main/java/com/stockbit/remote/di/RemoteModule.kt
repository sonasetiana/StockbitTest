package com.stockbit.remote.di

import com.stockbit.remote.ExampleDatasource
import com.stockbit.remote.ExampleService
import com.stockbit.remote.datasource.CryptoDataSource
import com.stockbit.remote.datasource.CryptoDataSourceImpl
import com.stockbit.remote.home.CryptoService
import com.stockbit.remote.network.BaseInterceptor
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

fun createRemoteModule(baseUrl: String) = module {

    factory<Interceptor> {
        HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.HEADERS)
    }

    factory {
        OkHttpClient.Builder()
            .addInterceptor(get())
            .addInterceptor(BaseInterceptor())
            .build()
    }

    single {
        Retrofit.Builder()
            .client(get())
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    factory{ get<Retrofit>().create(ExampleService::class.java) }

    factory { ExampleDatasource(get()) }

    factory{ get<Retrofit>().create(CryptoService::class.java) }

    factory<CryptoDataSource> { CryptoDataSourceImpl(get()) }
}