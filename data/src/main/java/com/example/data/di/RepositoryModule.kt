package com.example.data.di

import com.example.data.contract.repostory.ProductRepoImpl
import com.example.domain.contract.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideProductRepoImpl (impl :ProductRepoImpl): ProductRepository {

        return impl
    }
}