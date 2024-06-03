package com.example.jetpackcomposedemo.ui.screen.catlist

import androidx.lifecycle.ViewModel
import com.example.jetpackcomposedemo.core.extension.collectResourceFlow
import com.example.jetpackcomposedemo.core.network.RetrofitFactory
import com.example.jetpackcomposedemo.data.repository.CatBreedRepositoryImpl
import com.example.jetpackcomposedemo.data.service.CatService
import com.example.jetpackcomposedemo.domain.model.Cat
import com.example.jetpackcomposedemo.domain.usecase.GetCatBreedListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow


interface State

data object Loading : State
data object Success : State

data object Failure : State

sealed interface UIState
data object InitialUIState : UIState
class CatListState(
    val dataState: State = Loading,
    val listData: List<Cat> = listOf()
) : UIState

class CatListViewModel : ViewModel() {

    private val _catListStateFlow = MutableStateFlow(CatListState())
    val catListStateFlow get() = _catListStateFlow.asStateFlow()

    private var getCatBreedListUseCase: GetCatBreedListUseCase

    init {
        val catService = RetrofitFactory.createRetrofitService(CatService::class.java)
        val catBreedRepository = CatBreedRepositoryImpl(catService)
        getCatBreedListUseCase = GetCatBreedListUseCase(catBreedRepository)
    }

    fun fetchCat(limit: Int, page: Int) = collectResourceFlow(
        flow = getCatBreedListUseCase(limit, page),
        onLoading = {
            _catListStateFlow.value = CatListState(dataState = Loading, listData = listOf())
        },
        onSuccess = { list ->
            _catListStateFlow.value = CatListState(dataState = Success, listData = list)
        },
        onFailure = {
            _catListStateFlow.value = CatListState(dataState = Failure, listData = listOf())
        })
}