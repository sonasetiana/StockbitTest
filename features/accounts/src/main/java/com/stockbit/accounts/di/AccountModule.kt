package com.stockbit.accounts.di

import com.stockbit.accounts.domain.login.LoginInteractor
import com.stockbit.accounts.domain.login.LoginUseCase
import com.stockbit.accounts.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val accountModule = module {
    factory<LoginUseCase> { LoginInteractor(get()) }
    viewModel { LoginViewModel(get()) }
}