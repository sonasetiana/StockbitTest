package com.stockbit.home.di

import com.stockbit.home.domain.HomeInteractor
import com.stockbit.home.domain.HomeUseCase
import com.stockbit.home.presentation.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeModule = module {
    factory<HomeUseCase> { HomeInteractor(get()) }
    viewModel { HomeViewModel(get()) }
}