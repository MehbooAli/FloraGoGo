package com.example.floragogo.Data.Di

import com.example.floragogo.Data.Repository.Repository
import com.example.floragogo.Domain.Usecase.AddCartUseCase
import com.example.floragogo.Domain.Usecase.DeleteCartUseCase
import com.example.floragogo.Domain.Usecase.GetAllCartUseCase
import com.example.floragogo.Domain.Usecase.GetAllProductUseCase
import com.example.floragogo.Domain.Usecase.GetSelectedProductUseCase
import com.example.floragogo.Domain.Usecase.InsertProductUseCase
import com.example.floragogo.Domain.Usecase.SearchProductUseCase
import com.example.floragogo.Domain.Usecase.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUseCase(repository: Repository): UseCases {
        return UseCases(
            insertProductsUseCase = InsertProductUseCase(repository),
            getSelectedProductUseCase = GetSelectedProductUseCase(repository),
            getAllProductUseCase = GetAllProductUseCase(repository),
            getAllCartUseCase = GetAllCartUseCase(repository),
            addCartUseCase = AddCartUseCase(repository),
            deleteCart = DeleteCartUseCase(repository),
            searchProductUseCase = SearchProductUseCase(repository)
        )
    }

}