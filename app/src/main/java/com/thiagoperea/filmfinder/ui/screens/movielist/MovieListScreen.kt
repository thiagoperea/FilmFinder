package com.thiagoperea.filmfinder.ui.screens.movielist

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MovieListScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            text = "Upcoming"
        )
        Row {

            Box(
                modifier = Modifier
                    .size(width = 150.dp, height = 200.dp)
                    .background(MaterialTheme.colorScheme.primary)
                    .clickable {
                        println("Working!!")
                    }
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(32.dp)
                        .padding(top = 8.dp, end = 8.dp)
                        .background(MaterialTheme.colorScheme.onPrimary)
                )
            }
        }
    }
}