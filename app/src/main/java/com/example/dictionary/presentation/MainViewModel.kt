package com.example.dictionary.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dictionary.domain.repository.DictionaryRepository
import com.example.dictionary.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val dictionaryRepository: DictionaryRepository
) : ViewModel() {

    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()

    private var searchJob: Job? = null

    init {
        _mainState.update { state ->
            state.copy(searchWord = "word")
        }

        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            loadWordResult()
        }
    }

    fun onEvent(mainUiEvent: MainUIEvents) {
        when (mainUiEvent) {
            MainUIEvents.OnSearchClick -> {
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    loadWordResult()
                }
            }
            is MainUIEvents.OnSearchWordChange -> {
                _mainState.update { state ->
                    state.copy(searchWord = mainUiEvent.newWord.lowercase())
                }
            }
        }
    }

    private fun loadWordResult() {
        viewModelScope.launch {
            dictionaryRepository.getWordResult(
                mainState.value.searchWord
            ).collect { result ->
                when (result) {
                    is Result.Error -> {
                        // Handle error state if needed
                    }
                    is Result.Loading -> {
                        _mainState.update { state ->
                            state.copy(isLoading = result.isLoading)
                        }
                    }
                    is Result.Success -> {
                        result.data?.let { wordItem ->
                            _mainState.update { state ->
                                state.copy(wordItem = wordItem)
                            }
                        }
                    }
                }
            }
        }
    }
}
