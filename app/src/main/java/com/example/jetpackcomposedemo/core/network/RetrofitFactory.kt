package com.example.jetpackcomposedemo.core.network

import com.example.jetpackcomposedemo.BuildConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

object RetrofitFactory {
    private fun createOkhttpClient() = OkHttpClient.Builder().build()
    fun <T> createRetrofitService(service: Class<T>): T {
        val networkJson = Json { ignoreUnknownKeys = true }
        return Retrofit.Builder()
            .baseUrl(BuildConfig.baseApiUrl)
            .addConverterFactory(networkJson.asConverterFactory("application/json; charset=UTF8".toMediaType()))
            .client(createOkhttpClient())
            .build().create(service)
    }

}