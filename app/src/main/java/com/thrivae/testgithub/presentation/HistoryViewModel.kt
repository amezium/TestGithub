package com.thrivae.testgithub.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.thrivae.testgithub.data.db.AppDatabase
import com.thrivae.testgithub.data.db.DetailsUsersMapper
import com.thrivae.testgithub.data.db.GetHistoryRepositoryImpl
import com.thrivae.testgithub.domain.DetailsInfUserDto

class HistoryViewModel(application: Application): AndroidViewModel(application) {
    private val historyDao = AppDatabase.getInstance(application).historyDao()
    private val detailsUsersMapper = DetailsUsersMapper()
    private val getHistoryRepository = GetHistoryRepositoryImpl(historyDao, detailsUsersMapper)

    suspend fun getHistory(): List<DetailsInfUserDto> {
        return getHistoryRepository.getHistoryUsers()
    }

}