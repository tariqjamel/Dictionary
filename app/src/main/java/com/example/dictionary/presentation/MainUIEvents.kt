package com.example.dictionary.presentation

sealed class MainUIEvents {
    data class OnSearchWordChange(val newWord: String) : MainUIEvents()
    object OnSearchClick : MainUIEvents()

}