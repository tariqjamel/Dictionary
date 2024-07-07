package com.example.dictionary.data.dto

data class WordItemDto(
//    val license: License,
    val meanings: List<MeaningDto>? = null,
    val phonetic: String? = null,
//    val phonetics: List<Phonetic>,
    val word: String? = null,
    val phonetics: List<Phonetic>? = null
)