package com.stockbit.home.presentation

import com.stockbit.common.base.BaseViewModel
import com.stockbit.home.domain.HomeUseCase

class HomeViewModel(
    private val useCase: HomeUseCase
) : BaseViewModel() {
}