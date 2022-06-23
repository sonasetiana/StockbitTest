package com.stockbit.hiring

import android.app.Application
import com.stockbit.accounts.di.accountModule
import com.stockbit.hiring.di.appComponent
import com.stockbit.home.di.homeModule
import com.stockbit.local.di.localModule
import com.stockbit.remote.di.createRemoteModule
import com.stockbit.repository.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

open class App: Application() {
    override fun onCreate() {
        super.onCreate()
        configureDi()
    }

    // CONFIGURATION ---
    open fun configureDi() =
        startKoin {
            androidContext(this@App)
            modules(
                createRemoteModule(com.stockbit.remote.BuildConfig.BASE_URL),
                repositoryModule,
                localModule,
                accountModule,
                homeModule
            )
        }

    // PUBLIC API ---
    open fun provideComponent() = appComponent
}