package com.example.jetpackcomposedemo.data.repository

import android.util.Log
import com.example.jetpackcomposedemo.data.mapper.CatMapper
import com.example.jetpackcomposedemo.data.response.remote.response.ErrorApiResponse
import com.example.jetpackcomposedemo.data.response.remote.response.Failure
import com.example.jetpackcomposedemo.data.response.remote.response.Loading
import com.example.jetpackcomposedemo.data.response.remote.response.Resource
import com.example.jetpackcomposedemo.data.response.remote.response.Success
import com.example.jetpackcomposedemo.data.service.CatService
import com.example.jetpackcomposedemo.domain.model.Cat
import com.example.jetpackcomposedemo.domain.repository.CatBreedRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.serialization.json.Json
import retrofit2.HttpException

class CatBreedRepositoryImpl(private val catService: CatService) : CatBreedRepository {
    override fun getCatBreed(limit: Int, page: Int): Flow<Resource<List<Cat>>> {
        return flow {
            emit(Loading)
            val sourceData = catService.getBreedCat(limit, page)
            val mappedData = sourceData.map { CatMapper.mapToDomain(it) }
            val result = Success(mappedData)
            emit(result)
        }.catch { throwable ->
            Log.d("Repository Error", throwable.message.toString())
            val message =
                if (throwable is HttpException) {
                    try {
                        val json = Json { ignoreUnknownKeys = true }
                        val errorBody =
                            (throwable as? HttpException)?.response()?.errorBody()?.string()
                        errorBody?.let {
                            json.decodeFromString<ErrorApiResponse>(it).message.orEmpty()
                        } ?: ""
                    } catch (exception: Exception) {
                        exception.message.orEmpty()
                    }
                } else {
                    throwable.message.orEmpty()
                }
            emit(Failure(message))
        }.flowOn(Dispatchers.IO)
    }
}