package com.stockbit.home.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.stockbit.common.base.BaseViewModel
import com.stockbit.home.domain.HomeUseCase
import com.stockbit.model.entity.crypto.Watchlist
import com.stockbit.repository.utils.Resource

class HomeViewModel(
    private val useCase: HomeUseCase
) : BaseViewModel() {
    fun getListCrypto(page: Int, limit: Int): LiveData<Resource<List<Watchlist>>> {
        return useCase.getListCrypto(page, limit).asLiveData()
    }
}