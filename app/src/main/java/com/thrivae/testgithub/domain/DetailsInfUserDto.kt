package com.thrivae.testgithub.domain

import com.google.gson.annotations.SerializedName

data class DetailsInfUserDto(
    @SerializedName("avatar_url")
    val avatarUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("email")
    val email: String?,
    @SerializedName("company")
    val company: String? = "",
    @SerializedName("following")
    val following: String? = "",
    @SerializedName("followers")
    val followers: String? = "",
    @SerializedName("created_at")
    val createdAt: String? = ""
)
