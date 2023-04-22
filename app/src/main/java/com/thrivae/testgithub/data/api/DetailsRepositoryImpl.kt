package com.thrivae.testgithub.data.api

import com.thrivae.testgithub.domain.DetailsInfUserDto
import com.thrivae.testgithub.domain.DetailsRepository

class DetailsRepositoryImpl(
    private val apiService: ApiService
) : DetailsRepository {

    override suspend fun getUserDetails(userId: String): DetailsInfUserDto {
        return apiService.getUser(userId)
    }


}