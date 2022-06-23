package com.stockbit.model.entity.accounts

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Account")
data class AccountEntity(

    @PrimaryKey
    @ColumnInfo(name = "account_id")
    val id: String,

    @ColumnInfo(name = "username")
    val username: String,

    @ColumnInfo(name = "email")
    val email: String,

    @ColumnInfo(name = "phone")
    val phone: String,

    @ColumnInfo(name = "password")
    val password: String

) {
    constructor(model: AccountView) : this (
        id = model.id,
        username = model.username,
        email = model.email,
        phone = model.phone,
        password = model.password
    )
}