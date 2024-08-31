package com.example.floragogo.Domain.Usecase

import com.example.floragogo.Data.Model.DataModel
import com.example.floragogo.Data.Repository.Repository
import kotlinx.coroutines.flow.Flow

class GetAllCartUseCase(private  val repository: Repository) {
    suspend operator  fun invoke(isCart: Boolean): Flow<List<DataModel>> = repository.getAllProductCart(isCart)
}