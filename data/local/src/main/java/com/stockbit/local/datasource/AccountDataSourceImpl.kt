package com.stockbit.local.datasource

import com.stockbit.local.dao.AccountDao
import com.stockbit.model.Account
import com.stockbit.model.entity.AccountEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AccountDataSourceImpl(
    private val dao: AccountDao
) : AccountDataSource{
    override suspend fun saveAccount(data: Account) {
        dao.save(AccountEntity(data))
    }

    override suspend fun saveAccountList(items: List<Account>) {
        dao.save(items.map { AccountEntity(it) })
    }

    override fun getAccounts(): Flow<List<Account>> {
        return dao.getAccounts()
            .map { items ->
                items.map {
                    Account(it) }
            }
    }

    override fun findAccount(emailOrUsername: String, password: String): Flow<List<Account>> {
        return dao.findAccount(emailOrUsername, password)
            .map { items ->
                items.map {
                    Account(it)
                }
            }
    }

}