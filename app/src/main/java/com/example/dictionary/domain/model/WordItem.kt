package com.example.dictionary.domain.model

data class WordItem (
    val word: String,
    val meanings: List<Meaning>,
    val phonetic: String,
    val phoneticAudio: String
)