package com.example.floragogo.Data.Repository

import com.example.floragogo.Data.Model.DataModel
import com.example.floragogo.Domain.Repository.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val localDataSource: LocalDataSource) {
    suspend fun insertProducts(products: List<DataModel>) =
        localDataSource.insertProducts(products)

    fun getAllProduct(): Flow<List<DataModel>> = localDataSource.getAllProduct()

    suspend fun getSelectedProduct(productId: Int): DataModel =
        localDataSource.getSelectedProduct(productId = productId)

    fun getAllProductCart(isCart: Boolean): Flow<List<DataModel>> =
        localDataSource.getAllProductCart(isCart)

    suspend fun addCart(productItem: DataModel) = localDataSource.addCart(productItem)

    suspend fun deleteCart(productItem: DataModel) = localDataSource.deleteCart(productItem)

    fun searchProduct(query: String): Flow<List<DataModel>> = localDataSource.searchProduct(query)

}