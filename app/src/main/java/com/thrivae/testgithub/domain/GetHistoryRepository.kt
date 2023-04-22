package com.thrivae.testgithub.domain

interface GetHistoryRepository {

    suspend fun getHistoryUsers(): List<DetailsInfUserDto>
}