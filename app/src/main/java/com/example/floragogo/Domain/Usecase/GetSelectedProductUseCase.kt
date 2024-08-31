package com.example.floragogo.Domain.Usecase

import com.example.floragogo.Data.Model.DataModel
import com.example.floragogo.Data.Repository.Repository

class GetSelectedProductUseCase(private val repository: Repository) {
    suspend operator fun invoke(productId: Int): DataModel {
        return repository.getSelectedProduct(productId = productId)
    }
}