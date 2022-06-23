package com.stockbit.accounts.domain.login

import com.stockbit.model.entity.accounts.AccountView
import com.stockbit.repository.repository.accounts.AccountsRepository
import com.stockbit.repository.utils.Resource
import kotlinx.coroutines.flow.Flow

class LoginInteractor(
    private val repository: AccountsRepository
) : LoginUseCase {
    override fun initAccounts() {
        repository.setupAccounts()
    }

    override fun doLogin(usernameOrEmail: String, password: String): Flow<Resource<AccountView>> {
        return repository.doLogin(usernameOrEmail, password)
    }

    override val isLogin: Boolean
        get() = repository.isLogin
}