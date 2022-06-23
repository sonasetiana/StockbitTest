package com.stockbit.repository.repository.home

import com.stockbit.model.entity.crypto.Watchlist
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    fun getListCrypto(page: Int, limit: Int): Flow<Resource<List<Watchlist>>>
}