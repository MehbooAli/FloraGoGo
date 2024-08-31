package com.example.floragogo.Domain.Usecase

import com.example.floragogo.Data.Model.DataModel
import com.example.floragogo.Data.Repository.Repository

class DeleteCartUseCase(private  val repository: Repository) {
    suspend operator fun invoke(dataModel: DataModel)  = repository.deleteCart(dataModel)
}