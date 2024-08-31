//package com.example.floragogo.Data
//
//
//import com.example.floragogo.Data.Dao.DataModelDao
//import com.example.floragogo.Data.Model.DataModel
//import com.example.floragogo.Data.Repository.DatabaseRepository
//import kotlinx.coroutines.flow.Flow
//
//class OfflineDatabaseRepository(private val dataModelDao: DataModelDao) : DatabaseRepository {
//    override fun getAllItemsStream(): Flow<List<DataModel>> = dataModelDao.getAllItems()
//
//    override fun getItemStream(id: Int): Flow<DataModel?> = dataModelDao.getItemWithId(id)
//
//    override suspend fun insertItem(dataModel: DataModel) = dataModelDao.insert(dataModel)
//
//    override suspend fun deleteItem(dataModel: DataModel) = dataModelDao.delete(dataModel)
//
//    override suspend fun updateItem(dataModel: DataModel) = dataModelDao.update(dataModel)
//}