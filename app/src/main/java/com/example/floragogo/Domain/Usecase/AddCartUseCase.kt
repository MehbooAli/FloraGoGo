package com.example.floragogo.Domain.Usecase

import com.example.floragogo.Data.Model.DataModel
import com.example.floragogo.Data.Repository.Repository

class AddCartUseCase(private  val repository: Repository) {
    suspend operator fun invoke(dataModel: DataModel) = repository.addCart(dataModel)
}