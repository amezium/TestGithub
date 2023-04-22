package com.thrivae.testgithub.domain

import com.google.gson.annotations.SerializedName

data class UserMainDto(
    @SerializedName ("login")
    val login: String,
    @SerializedName ("id")
    val id: String,
    @SerializedName ("avatar_url")
    val avatarUrl: String
    )