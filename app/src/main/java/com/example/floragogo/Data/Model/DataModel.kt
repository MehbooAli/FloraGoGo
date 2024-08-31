package com.example.floragogo.Data.Model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.floragogo.utils.Constants.PRODUCT_DATABASE_TABLE

// Adding @Entity tells here that this will be a table of out database
@Entity(tableName = PRODUCT_DATABASE_TABLE)
data class DataModel(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val price: Double,
    val quantity: Int,
    var isCart: Boolean = false,
)
