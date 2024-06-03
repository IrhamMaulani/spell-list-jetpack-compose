package com.example.jetpackcomposedemo.data.response.remote.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CatResponse(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String?,
    @SerialName("origin")
    val origin: String?,
    @SerialName("temperament")
    val temperament: String?,
    @SerialName("reference_image_id")
    val referenceImageId: String?
)