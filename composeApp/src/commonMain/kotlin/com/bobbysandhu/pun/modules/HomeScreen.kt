package com.bobbysandhu.pun.modules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bobbysandhu.pun.modules.components.JokeView
import com.bobbysandhu.pun.ui.HomeScreenViewModel

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = HomeScreenViewModel()
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getRandomJokes()
    }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                uiState.jokes,
                key = { it.id }
            ) { joke ->
                JokeView(joke)
            }
        }
    }
}