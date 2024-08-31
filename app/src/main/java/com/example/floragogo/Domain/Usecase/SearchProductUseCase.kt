package com.example.floragogo.Domain.Usecase

import com.example.floragogo.Data.Repository.Repository

class SearchProductUseCase(private val repository: Repository) {
    operator fun invoke(query: String) = repository.searchProduct(query)
}