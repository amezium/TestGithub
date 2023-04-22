package com.thrivae.testgithub.data.db

import com.thrivae.testgithub.domain.AddHistoryRepository
import com.thrivae.testgithub.domain.DetailsInfUserDto

class AddHistoryRepositoryImpl(
    private val historyDao: HistoryDao,
    private val detailsUsersMapper: DetailsUsersMapper
): AddHistoryRepository {

    override suspend fun addUsersHistory(user: DetailsInfUserDto) {
        historyDao.insertHistory(detailsUsersMapper.mapEntityToDbModel(user))
    }
}