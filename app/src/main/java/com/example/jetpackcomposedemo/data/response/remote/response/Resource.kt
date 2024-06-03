package com.example.jetpackcomposedemo.data.response.remote.response

sealed interface Resource<out Data>

data object Initial : Resource<Nothing>
data class Success<out Data>(val data: Data) : Resource<Data>
data object Loading : Resource<Nothing>
data class Failure(val message: String) : Resource<Nothing>

inline fun <Data> Resource<Data>.onSuccess(onSuccess: (data: Data) -> Unit): Resource<Data> {
    if (this is Success) onSuccess(data)
    return this
}

inline fun <Data> Resource<Data>.onFailure(onFailure: (message: String) -> Unit): Resource<Data> {
    if (this is Failure) onFailure(message)
    return this
}

inline fun <Data> Resource<Data>.onLoading(onLoading: () -> Unit): Resource<Data> {
    if (this is Loading) onLoading()
    return this
}