package com.thrivae.testgithub.domain

interface DetailsRepository {
    suspend fun getUserDetails(userId: String): DetailsInfUserDto
}