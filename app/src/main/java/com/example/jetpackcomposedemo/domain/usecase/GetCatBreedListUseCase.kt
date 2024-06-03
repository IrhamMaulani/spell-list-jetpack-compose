package com.example.jetpackcomposedemo.domain.usecase

import com.example.jetpackcomposedemo.data.response.remote.response.Resource
import com.example.jetpackcomposedemo.domain.model.Cat
import com.example.jetpackcomposedemo.domain.repository.CatBreedRepository
import kotlinx.coroutines.flow.Flow

class GetCatBreedListUseCase(private val catBreedRepository: CatBreedRepository) {
    operator fun invoke(limit: Int, page: Int): Flow<Resource<List<Cat>>> {
        return catBreedRepository.getCatBreed(limit, page)
    }
}