package com.stockbit.home.domain

import com.stockbit.model.entity.crypto.Watchlist
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow

interface HomeUseCase {
    fun getListCrypto(page: Int, limit: Int): Flow<Resource<List<Watchlist>>>
}