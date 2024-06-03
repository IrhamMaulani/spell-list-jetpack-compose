package com.example.jetpackcomposedemo.data.response.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class DataResponse<T>(
    val id: String
)

@Serializable
data class ListResponse<T>(
    val list: List<T>
)
