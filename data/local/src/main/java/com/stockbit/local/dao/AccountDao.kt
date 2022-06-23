package com.stockbit.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.stockbit.model.entity.accounts.AccountEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AccountDao : BaseDao<AccountEntity>() {

    suspend fun save(entity: AccountEntity){
        insert(entity)
    }

    suspend fun save(listEntity: List<AccountEntity>) {
        insert(listEntity)
    }

    @Query("SELECT * FROM Account")
    abstract fun getAccounts() : Flow<List<AccountEntity>>

    @Query("select count() from Account")
    abstract fun getTotalAccount(): Flow<Int>

    @Query("SELECT * FROM Account WHERE (email = :emailOrUsername or username = :emailOrUsername) AND password = :password")
    abstract fun findAccount(
        emailOrUsername: String,
        password: String
    ) : Flow<List<AccountEntity>>
}