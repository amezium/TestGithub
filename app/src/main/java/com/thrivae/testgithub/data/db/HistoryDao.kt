package com.thrivae.testgithub.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface HistoryDao {

    @Query("SELECT * FROM table_history")
    suspend fun getUserHistory(): List<HistoryUserDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHistory(historyUser: HistoryUserDbModel)


}