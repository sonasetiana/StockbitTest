package com.stockbit.local.datasource

import com.stockbit.model.Account
import kotlinx.coroutines.flow.Flow

interface AccountDataSource {
    suspend fun saveAccount(data: Account)
    suspend fun saveAccountList(items: List<Account>)
    fun getAccounts(): Flow<List<Account>>
    fun findAccount(emailOrUsername: String, password: String) : Flow<List<Account>>
}