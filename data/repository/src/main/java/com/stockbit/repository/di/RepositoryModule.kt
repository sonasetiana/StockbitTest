package com.stockbit.repository.di

import com.stockbit.repository.AppDispatchers
import com.stockbit.repository.ExampleRepository
import com.stockbit.repository.ExampleRepositoryImpl
import com.stockbit.repository.repository.accounts.AccountsRepository
import com.stockbit.repository.repository.accounts.AccountsRepositoryImpl
import com.stockbit.repository.repository.home.HomeRepository
import com.stockbit.repository.repository.home.HomeRepositoryImpl
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val repositoryModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
    factory { ExampleRepositoryImpl(get(), get()) as ExampleRepository }
    factory<AccountsRepository> { AccountsRepositoryImpl(get(), get()) }
    factory<HomeRepository> { HomeRepositoryImpl(get(), get()) }
}