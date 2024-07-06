package com.example.dictionary.data.dto

data class Phonetic(
    val audio: String,
    val license: License,
    val sourceUrl: String,
    val text: String
)