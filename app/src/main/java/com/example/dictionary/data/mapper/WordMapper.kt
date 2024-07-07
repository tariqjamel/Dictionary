package com.example.dictionary.data.mapper

import com.example.dictionary.data.dto.DefinitionDto
import com.example.dictionary.data.dto.MeaningDto
import com.example.dictionary.data.dto.WordItemDto
import com.example.dictionary.domain.model.Definition
import com.example.dictionary.domain.model.Meaning
import com.example.dictionary.domain.model.WordItem

fun WordItemDto.toWordItem() = WordItem(
    word = word ?: "",
    meanings = meanings?.map {
        it.toMeaning()
    } ?: emptyList(),
    phonetic = phonetic ?: "",
    phoneticAudio = phonetics?.firstOrNull()?.audio ?: "" // Map the phonetic audio URL
)

fun MeaningDto.toMeaning() = Meaning(
    definition = definitionDtoToDefinition(definitions?.get(0)),
    partOfSpeech = partOfSpeech ?: ""
)

fun definitionDtoToDefinition(
    definitionDto: DefinitionDto?
) = Definition(
    definition = definitionDto?.definition ?: "",
    example = definitionDto?.example ?: ""
)
