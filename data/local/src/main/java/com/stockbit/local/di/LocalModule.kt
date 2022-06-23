package com.stockbit.local.di

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.stockbit.local.AppDatabase
import com.stockbit.local.datasource.AccountDataSource
import com.stockbit.local.datasource.AccountDataSourceImpl
import com.stockbit.local.pref.DataPreference
import com.stockbit.local.pref.DataPreferenceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val DATABASE = "DATABASE"

val localModule = module {
    single(named(DATABASE)) { AppDatabase.buildDatabase(androidContext()) }
    single { Gson() }
    factory { (get(named(DATABASE)) as AppDatabase).exampleDao() }
    factory { (get(named(DATABASE)) as AppDatabase).accountDao() }
    single<SharedPreferences> {
        androidContext().getSharedPreferences("app_preference", Context.MODE_PRIVATE)
    }

    factory<DataPreference> { DataPreferenceImpl(get(), get()) }
    factory<AccountDataSource> { AccountDataSourceImpl(get(), get()) }
}