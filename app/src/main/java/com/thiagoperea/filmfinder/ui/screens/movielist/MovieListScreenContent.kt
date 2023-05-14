package com.thiagoperea.filmfinder.ui.screens.movielist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thiagoperea.filmfinder.R
import com.thiagoperea.filmfinder.data.model.MovieListItemResponse

@Composable
fun MovieListScreenContent(
    movieList: List<MovieListItemResponse>
) {

    if (movieList.isEmpty()) {
        return Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.no_movie_found)
            )
        }
    }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
        content = {
            items(movieList) { movie ->

            }
        }
    )


}
