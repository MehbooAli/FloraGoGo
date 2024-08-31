package com.example.floragogo.Data.Di

import android.content.Context
import androidx.room.Room
import com.example.floragogo.Data.Dao.DataModelDatabase
import com.example.floragogo.Data.Repository.LocalDataSourceImpl
import com.example.floragogo.Domain.Repository.LocalDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import com.example.floragogo.utils.Constants.PRODUCT_DATABASE

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): DataModelDatabase  {
        return Room.databaseBuilder(context, DataModelDatabase::class.java, PRODUCT_DATABASE).build()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(dataModelDatabase: DataModelDatabase): LocalDataSource {
        return  LocalDataSourceImpl(dataModelDatabase)
    }
}