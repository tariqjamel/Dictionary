package com.example.dictionary.data.dto

data class MeaningDto(
//    val antonyms: List<Any>,
    val definitions: List<DefinitionDto>? = null,
    val partOfSpeech: String? = null,
//    val synonyms: List<String>
)