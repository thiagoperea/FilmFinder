package com.thiagoperea.filmfinder.ui.screens.movielist.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thiagoperea.filmfinder.data.model.MovieListItemResponse

@Composable
fun MovieListItemView(
    modifier: Modifier = Modifier,
    data: MovieListItemResponse,
    onItemClicked: (MovieListItemResponse) -> Unit
) {
    Box(
        modifier = modifier
            .size(width = 100.dp, height = 150.dp)
            .clickable {
                onItemClicked(data)
            }
    ) {
        //TODO IMG HERE

        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .size(32.dp)
                .padding(top = 8.dp, end = 8.dp)
                .background(MaterialTheme.colorScheme.onPrimary)
        )
    }
}