package com.example.floragogo.Data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.floragogo.Data.Model.DataModel
import kotlinx.coroutines.flow.Flow

@Dao
interface DataModelDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(products: List<DataModel>)

    @Query("SELECT * from product_table")
    fun getAllItems(): Flow<List<DataModel>>

    @Query("SELECT * from product_table WHERE id= :productId")
    fun getItemWithId(productId: Int): DataModel

    @Query("SELECT * FROM product_table WHERE isCart= :isCart")
    fun getAllProductCart(isCart: Boolean): Flow<List<DataModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCart(dataModel: DataModel)

    @Update
    suspend fun deleteCart(dataModel: DataModel)

    @Delete
    suspend fun delete(dataModel: DataModel)

    @Query("SELECT * from product_table WHERE title LIKE '%' || :query  || '%'")
    fun searchProduct(query: String): Flow<List<DataModel>>
}
