package com.bobbysandhu.pun.modules.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bobbysandhu.pun.models.Joke

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun JokeView(joke: Joke) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        onClick = {},
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color.LightGray
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(text = joke.setup)
            Text(text = joke.punchline)
        }
    }
}