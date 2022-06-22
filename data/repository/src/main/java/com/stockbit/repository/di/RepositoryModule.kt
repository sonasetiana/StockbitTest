package com.stockbit.repository.di

import com.stockbit.local.datasource.AccountDataSource
import com.stockbit.local.datasource.AccountDataSourceImpl
import com.stockbit.repository.AppDispatchers
import com.stockbit.repository.ExampleRepository
import com.stockbit.repository.ExampleRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { ExampleRepositoryImpl(get(), get()) as ExampleRepository }
    factory<AccountDataSource> { AccountDataSourceImpl(get()) }
}