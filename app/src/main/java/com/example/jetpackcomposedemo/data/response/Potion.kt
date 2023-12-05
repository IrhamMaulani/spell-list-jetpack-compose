package com.example.jetpackcomposedemo.data.response

import com.squareup.moshi.Json

data class Potion(
    @Json(name = "slug") val slug: String?,
    @Json(name = "characteristics") val characteristics: String?,
    @Json(name = "difficulty") val difficulty: String?,
    @Json(name = "effect") val effect: String?,
    @Json(name = "image") val image: String?,
    @Json(name = "inventors") val inventors: String? = null,
    @Json(name = "ingredients") val ingredients: String,
    @Json(name = "manufacturers") val manufacturers: String? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "side_effects") val sideEffects: String? = null,
    @Json(name = "time") val time: String? = null,
    @Json(name = "wiki") val wiki: String
)
