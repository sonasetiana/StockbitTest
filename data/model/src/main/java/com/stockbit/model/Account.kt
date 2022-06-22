package com.stockbit.model

import com.stockbit.model.entity.AccountEntity

data class Account(
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

