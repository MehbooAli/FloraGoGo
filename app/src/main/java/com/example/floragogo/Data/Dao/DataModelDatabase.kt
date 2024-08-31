package com.example.floragogo.Data.Dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.floragogo.Data.Model.DataModel

// Database class with a singleton Instance object.
@Database(entities = [DataModel::class], version = 2, exportSchema = false)
abstract class  DataModelDatabase : RoomDatabase() {
    abstract fun dataModelDao(): DataModelDao
}
