package com.thrivae.testgithub.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [HistoryUserDbModel::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    companion object{
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE =   Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "geek"
                    ).build()
                }
            }
            return INSTANCE!!
        }

    }
    abstract fun historyDao(): HistoryDao
}