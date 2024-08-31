package com.example.floragogo.Domain.Repository

import com.example.floragogo.Data.Model.DataModel
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun insertProducts(dataModel: List<DataModel>)
    fun getAllProduct(): Flow<List<DataModel>>
    suspend fun getSelectedProduct(productId: Int): DataModel
    fun getAllProductCart(isCart: Boolean): Flow<List<DataModel>>
    suspend fun addCart(dataModel: DataModel)
    suspend fun deleteCart(dataModel: DataModel)
    fun searchProduct(query: String): Flow<List<DataModel>>
}