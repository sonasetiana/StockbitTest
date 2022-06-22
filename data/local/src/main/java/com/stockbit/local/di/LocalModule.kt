package com.stockbit.local.di

import com.stockbit.local.AppDatabase
import com.stockbit.local.datasource.AccountDataSource
import com.stockbit.local.datasource.AccountDataSourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module

private const val DATABASE = "DATABASE"

val localModule = module {
    single(named(DATABASE)) { AppDatabase.buildDatabase(androidContext()) }
    factory { (get(named(DATABASE)) as AppDatabase).exampleDao() }
    factory<AccountDataSource> { AccountDataSourceImpl(get()) }
}