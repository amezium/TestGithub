package com.thrivae.testgithub.domain

interface AddHistoryRepository {
    suspend fun addUsersHistory(user: DetailsInfUserDto)
}