package com.stockbit.local.datasource

import com.stockbit.local.dao.AccountDao
import com.stockbit.local.pref.DataPreference
import com.stockbit.model.entity.accounts.AccountView
import com.stockbit.model.entity.accounts.AccountEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AccountDataSourceImpl(
    private val dao: AccountDao,
    private val pref: DataPreference
) : AccountDataSource{
    override suspend fun saveAccount(data: AccountView) {
        dao.save(AccountEntity(data))
    }

    override suspend fun saveAccountList(items: List<AccountView>) {
        dao.save(items.map { AccountEntity(it) })
    }

    override fun getAccounts(): Flow<List<AccountView>> {
        return dao.getAccounts()
            .map { items ->
                items.map {
                    AccountView(it) }
            }
    }

    override fun getTotalAccount(): Flow<Int> {
        return dao.getTotalAccount()
    }

    override fun findAccount(emailOrUsername: String, password: String): Flow<List<AccountView>> {
        return dao.findAccount(emailOrUsername, password)
            .map { items ->
                items.map {
                    AccountView(it)
                }
            }
    }

    override fun saveAccountToPref(account: AccountView) {
        pref.saveAccount(account)
    }

    override fun getAccountFromPref(): AccountView? {
        return pref.getAccount()
    }

    override fun removeAccountFromPref() {
        pref.removeAccount()
    }

}