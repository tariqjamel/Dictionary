package com.example.dictionary.di

import com.example.dictionary.data.repository.DictionaryRepositoryImpl
import com.example.dictionary.domain.repository.DictionaryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDictionaryRepository(
        dictionaryRepositoryImpl: DictionaryRepositoryImpl
    ): DictionaryRepository
}