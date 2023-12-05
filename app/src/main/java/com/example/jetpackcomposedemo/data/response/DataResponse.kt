package com.example.jetpackcomposedemo.data.response

import com.squareup.moshi.Json

data class DataResponse<T>(
    @Json(name = "id")
    val id: String?,
    @Json(name = "type")
    val type: String?,
    @Json(name = "attributes")
    val attributes: T
)
