package com.example.jetpackcomposedemo.core.extension

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposedemo.data.response.remote.response.Resource
import com.example.jetpackcomposedemo.data.response.remote.response.onFailure
import com.example.jetpackcomposedemo.data.response.remote.response.onLoading
import com.example.jetpackcomposedemo.data.response.remote.response.onSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

fun <T> ViewModel.collectResourceFlow(
    flow: Flow<Resource<T>>,
    dispatcher: kotlin.coroutines.CoroutineContext = Dispatchers.IO,
    onLoading: () -> Unit = {},
    onSuccess: (T) -> Unit = {},
    onFailure: (String) -> Unit = { }
) {
    viewModelScope.launch {
        flow.flowOn(dispatcher)
            .catch { exception ->
                Log.d("ViewModel Error", exception.message.toString())
            }
            .collect { resource ->
                resource.onLoading(onLoading)
                resource.onSuccess(onSuccess)
                resource.onFailure(onFailure)
            }
    }
}