package com.example.floragogo.Screens.ItemDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.floragogo.Data.Model.DataModel
import com.example.floragogo.Domain.Usecase.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ItemDetailViewModel @Inject constructor(private val useCases: UseCases): ViewModel(){
    fun addCart(dataModel: DataModel) = viewModelScope.launch {
        useCases.addCartUseCase.invoke(dataModel)
    }
}