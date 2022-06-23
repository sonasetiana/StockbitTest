package com.stockbit.model.entity.accounts

import com.stockbit.model.entity.accounts.AccountEntity

data class AccountView(
    val id: String,
    val username: String,
    val email: String,
    val phone: String,
    val password: String
){
    constructor(entity: AccountEntity): this(
        id = entity.id,
        username = entity.username,
        email = entity.email,
        phone = entity.phone,
        password = entity.password
    )
}

