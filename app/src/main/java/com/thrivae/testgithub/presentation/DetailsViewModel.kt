package com.thrivae.testgithub.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.thrivae.testgithub.data.api.ApiFactory
import com.thrivae.testgithub.data.api.DetailsRepositoryImpl
import com.thrivae.testgithub.data.db.AddHistoryRepositoryImpl
import com.thrivae.testgithub.data.db.AppDatabase
import com.thrivae.testgithub.data.db.DetailsUsersMapper
import com.thrivae.testgithub.domain.DetailsInfUserDto

class DetailsViewModel(application: Application): AndroidViewModel(application) {

    private val apiService = ApiFactory.create()
    private val historyDao = AppDatabase.getInstance(application).historyDao()

    private val detailsUsersMapper = DetailsUsersMapper()

    private val allUsersRepository = DetailsRepositoryImpl(apiService)
    private val addHistoryRepository = AddHistoryRepositoryImpl(historyDao, detailsUsersMapper)

    suspend fun getDetailsUser(userId: String): DetailsInfUserDto{
        return allUsersRepository.getUserDetails(userId)
    }

    suspend fun insertDbHistory(user: DetailsInfUserDto){
        addHistoryRepository.addUsersHistory(user)
    }
}