package com.stockbit.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.stockbit.local.converter.Converters
import com.stockbit.local.dao.AccountDao
import com.stockbit.local.dao.ExampleDao
import com.stockbit.model.ExampleModel
import com.stockbit.model.entity.accounts.AccountEntity

@Database(entities = [ExampleModel::class, AccountEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {

    // DAO
    abstract fun exampleDao(): ExampleDao

    abstract fun accountDao() : AccountDao

    companion object {

        fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "AppStockbit.db")
                .build()
    }
}