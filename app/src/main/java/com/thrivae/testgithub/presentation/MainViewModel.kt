package com.thrivae.testgithub.presentation

import androidx.lifecycle.ViewModel
import com.thrivae.testgithub.data.api.AllUsersRepositoryImpl
import com.thrivae.testgithub.data.api.ApiFactory
import com.thrivae.testgithub.domain.UserMainDto

class MainViewModel: ViewModel() {
    private val apiService = ApiFactory.create()
    private val allUsersRepository = AllUsersRepositoryImpl(apiService)

    suspend fun getAllUsers(lastId: Int, countUsers: Int):List<UserMainDto> {
        return allUsersRepository.getAllUsers(lastId, countUsers)
    }
}