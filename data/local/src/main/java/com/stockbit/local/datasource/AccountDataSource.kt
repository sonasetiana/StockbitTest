package com.stockbit.local.datasource

import com.stockbit.model.entity.accounts.AccountView
import kotlinx.coroutines.flow.Flow

interface AccountDataSource {
    suspend fun saveAccount(data: AccountView)
    suspend fun saveAccountList(items: List<AccountView>)
    fun getAccounts(): Flow<List<AccountView>>
    fun getTotalAccount(): Flow<Int>
    fun findAccount(emailOrUsername: String, password: String) : Flow<List<AccountView>>
}