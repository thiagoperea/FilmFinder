package com.thiagoperea.filmfinder.ui.screens.moviedetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.thiagoperea.filmfinder.data.model.MovieCastResponse
import com.thiagoperea.filmfinder.data.model.MovieDetailsResponse
import com.thiagoperea.filmfinder.data.model.MovieVideosResponse

@Composable
fun MovieDetailsScreenContent(
    details: MovieDetailsResponse,
    cast: MovieCastResponse,
    videos: MovieVideosResponse
) {
    val formattedVote = String.format("%.1f", details.voteAverage)

    Column {
        Box(
            modifier = Modifier.fillMaxWidth()
                .height(100.dp)
                .background(MaterialTheme.colorScheme.primaryContainer)
        )

        Text(details.title)

        Row {

            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(32.dp))
                    .background(MaterialTheme.colorScheme.primaryContainer),
                text = formattedVote,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}