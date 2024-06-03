package com.example.jetpackcomposedemo.data.mapper

import com.example.jetpackcomposedemo.BuildConfig
import com.example.jetpackcomposedemo.data.response.remote.response.CatResponse
import com.example.jetpackcomposedemo.domain.model.Cat

object CatMapper : DomainMapper<CatResponse, Cat> {
    override fun mapToDomain(input: CatResponse): Cat = with(input) {
        val image = BuildConfig.baseUrlImage + referenceImageId + ".jpg"
        Cat(
            id = id.orEmpty(),
            name = name.orEmpty(),
            image = image,
            origin = origin.orEmpty(),
            temperament = temperament.orEmpty()
        )
    }
}