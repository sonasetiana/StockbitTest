package com.stockbit.repository.repository.accounts

import com.stockbit.model.Account
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow

interface AccountsRepository {
    suspend fun setupAccounts()
    suspend fun doLogin(usernameOrEmail: String, password: String) : Flow<Resource<Account>>
}