package com.thrivae.testgithub.data.api

import com.thrivae.testgithub.domain.AllUsersRepository
import com.thrivae.testgithub.domain.UserMainDto

class AllUsersRepositoryImpl(
    private val apiService: ApiService
): AllUsersRepository {


    override suspend fun getAllUsers(lastId: Int, countUsers: Int): List<UserMainDto> {
        return apiService.getUsers(lastId, countUsers)
    }
}