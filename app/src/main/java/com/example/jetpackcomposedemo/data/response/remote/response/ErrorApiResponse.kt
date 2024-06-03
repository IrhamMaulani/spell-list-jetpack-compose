package com.example.jetpackcomposedemo.data.response.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorApiResponse(
    @SerialName("message")
    val message: String?,
)