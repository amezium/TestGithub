package com.thrivae.testgithub.data.db

import com.thrivae.testgithub.domain.DetailsInfUserDto
import com.thrivae.testgithub.domain.GetHistoryRepository

class GetHistoryRepositoryImpl(
    private val historyDao: HistoryDao,
    private val detailsUsersMapper: DetailsUsersMapper
): GetHistoryRepository {

    override suspend fun getHistoryUsers(): List<DetailsInfUserDto> {
        return detailsUsersMapper.mapListDbModelToListEntity(historyDao.getUserHistory())
    }
}