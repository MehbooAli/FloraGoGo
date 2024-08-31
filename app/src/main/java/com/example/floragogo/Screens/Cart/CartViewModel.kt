package com.example.floragogo.Screens.Cart

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.floragogo.Data.Model.DataModel
import com.example.floragogo.Domain.Usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


@HiltViewModel
class CartViewModel @Inject  constructor(private val useCases: UseCases): ViewModel() {
    private val _productCartList = MutableStateFlow<List<DataModel>>(emptyList())
    val productCartList = _productCartList.asStateFlow()

    init {
        getAllProductCartList()
    }

    private fun getAllProductCartList() {
        viewModelScope.launch(Dispatchers.IO) {
            useCases.getAllProductUseCase.invoke().collect { values ->
                _productCartList.value = values
                Log.d("CartViewModel", ">>>>>>>>>>>>>>>>>>> ${_productCartList.value} $productCartList")
            }
        }
    }
}