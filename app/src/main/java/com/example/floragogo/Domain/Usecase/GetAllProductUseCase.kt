package com.example.floragogo.Domain.Usecase

import com.example.floragogo.Data.Model.DataModel
import com.example.floragogo.Data.Repository.Repository
import kotlinx.coroutines.flow.Flow

class GetAllProductUseCase(private val repository: Repository) {
    operator fun invoke(): Flow<List<DataModel>> = repository.getAllProduct()
}