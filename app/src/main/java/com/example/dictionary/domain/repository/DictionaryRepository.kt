package com.example.dictionary.domain.repository

import com.example.dictionary.domain.model.WordItem
import com.example.dictionary.util.Result
import kotlinx.coroutines.flow.Flow

interface DictionaryRepository {
    suspend fun getWordResult(
        word: String

    ): Flow<Result<WordItem>>
}