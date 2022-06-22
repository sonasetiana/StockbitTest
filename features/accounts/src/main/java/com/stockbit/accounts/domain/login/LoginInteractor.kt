package com.stockbit.accounts.domain.login

import com.stockbit.model.Account
import com.stockbit.repository.repository.accounts.AccountsRepository
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow

class LoginInteractor(
    private val repository: AccountsRepository
) : LoginUseCase {
    override fun initAccounts() {
        repository.setupAccounts()
    }

    override fun doLogin(usernameOrEmail: String, password: String): Flow<Resource<Account>> {
        return repository.doLogin(usernameOrEmail, password)
    }
}