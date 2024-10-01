package com.bobbysandhu.pun.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobbysandhu.pun.data.DataRepository
import com.bobbysandhu.pun.modules.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {
    private val dataRepository = DataRepository()

    private val _uiState = MutableStateFlow(HomeUiState(jokes = emptyList()))
    val uiState = _uiState.asStateFlow()

    suspend fun getRandomJokes() {
        viewModelScope.launch {
            val jokes = dataRepository.getRandomJokes()
            _uiState.update {
                HomeUiState(jokes = jokes)
            }
        }
    }
}