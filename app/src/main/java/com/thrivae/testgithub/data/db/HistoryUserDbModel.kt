package com.thrivae.testgithub.data.db


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_history")
data class HistoryUserDbModel(
    @PrimaryKey
     val name: String,
     val email: String?,
     val avatar: String?
)