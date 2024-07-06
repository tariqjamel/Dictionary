package com.example.dictionary.presentation

import com.example.dictionary.domain.model.WordItem

data class MainState(
    val isLoading: Boolean = false,
    val searchWord: String = "",
    val wordItem: WordItem? =null
)
