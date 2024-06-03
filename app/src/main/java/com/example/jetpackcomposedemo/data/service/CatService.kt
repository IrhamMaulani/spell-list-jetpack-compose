package com.example.jetpackcomposedemo.data.service

import com.example.jetpackcomposedemo.data.response.remote.response.CatResponse
import com.example.jetpackcomposedemo.data.response.remote.response.ListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CatService {
    @GET("breeds")
    suspend fun getBreedCat(
        @Query("limit") limit: Int, @Query("page") page: Int
    ): List<CatResponse>
}