package com.thrivae.testgithub.domain

interface AllUsersRepository {

    suspend fun getAllUsers(lastId: Int, countUsers: Int): List<UserMainDto>
}