package com.thrivae.testgithub.data.db

import com.thrivae.testgithub.domain.DetailsInfUserDto

class DetailsUsersMapper {

    fun mapEntityToDbModel(detailsInfUserDto: DetailsInfUserDto) = HistoryUserDbModel(
        name = detailsInfUserDto.name,
        email = detailsInfUserDto.email,
        avatar = detailsInfUserDto.avatarUrl
    )

    fun mapDbModelToEntity(historyUserDbModel: HistoryUserDbModel) = DetailsInfUserDto(
        name = historyUserDbModel.name,
        email = historyUserDbModel.email,
        avatarUrl = historyUserDbModel.avatar.toString()
    )

    fun mapListDbModelToListEntity(list: List<HistoryUserDbModel>) =
        list.map { mapDbModelToEntity(it) }
}