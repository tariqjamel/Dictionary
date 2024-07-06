package com.example.dictionary.data.dto

data class WordItemDto(
//    val license: License,
    val meanings: List<MeaningDto>? = null,
    val phonetic: String? = null,
//    val phonetics: List<Phonetic>,
//    val sourceUrls: List<String>,
    val word: String? = null
)