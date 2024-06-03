package com.example.jetpackcomposedemo.domain.repository

import com.example.jetpackcomposedemo.data.response.remote.response.Resource
import com.example.jetpackcomposedemo.domain.model.Cat
import com.example.jetpackcomposedemo.domain.model.ListData
import kotlinx.coroutines.flow.Flow

interface CatBreedRepository {
    fun getCatBreed(limit: Int, page: Int): Flow<Resource<List<Cat>>>
}