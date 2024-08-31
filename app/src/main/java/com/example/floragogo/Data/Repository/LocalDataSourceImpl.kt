package com.example.floragogo.Data.Repository

import com.example.floragogo.Data.Dao.DataModelDatabase
import com.example.floragogo.Data.Model.DataModel
import com.example.floragogo.Domain.Repository.LocalDataSource
import kotlinx.coroutines.flow.Flow

class LocalDataSourceImpl(dataModelDatabase: DataModelDatabase): LocalDataSource {
    private val dataModelDao = dataModelDatabase.dataModelDao()

    override suspend fun insertProducts(dataModel: List<DataModel>) =
        dataModelDao.insertProducts(dataModel)

    override fun getAllProduct(): Flow<List<DataModel>> = dataModelDao.getAllItems()

    override suspend fun getSelectedProduct(productId: Int): DataModel =
        dataModelDao.getItemWithId(productId = productId)

    override fun getAllProductCart(isCart: Boolean): Flow<List<DataModel>> =
        dataModelDao.getAllProductCart(isCart)

    override suspend fun addCart(dataModel: DataModel) = dataModelDao.addCart(dataModel)

    override suspend fun deleteCart(dataModel: DataModel) {
        dataModel.isCart = false
        dataModelDao.deleteCart(dataModel)
    }

    override fun searchProduct(query: String): Flow<List<DataModel>> =
        dataModelDao.searchProduct(query)
}