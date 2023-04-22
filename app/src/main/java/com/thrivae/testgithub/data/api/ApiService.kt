package com.thrivae.testgithub.data.api

import com.thrivae.testgithub.domain.DetailsInfUserDto
import com.thrivae.testgithub.domain.UserMainDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    suspend fun getUsers(
        @Query("since") lastId: Int,
        @Query("per_page") countUsers: Int
    ): List<UserMainDto>

    @GET("users/{username}")
    suspend fun getUser(@Path("username") userId: String): DetailsInfUserDto
}