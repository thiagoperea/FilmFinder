package com.thiagoperea.filmfinder.ui.screens.movielist.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.thiagoperea.filmfinder.data.model.MovieListItemResponse
import com.thiagoperea.filmfinder.data.remote.TmdbConstants

@Composable
fun MovieListItemView(
    modifier: Modifier = Modifier,
    data: MovieListItemResponse,
    onItemClicked: () -> Unit
) {
    Box(
        modifier = modifier
            .size(width = 80.dp, height = 140.dp)
            .clickable {
                onItemClicked()
            }
    ) {
        AsyncImage(
            modifier = Modifier.clip(RoundedCornerShape(8.dp)),
            model = TmdbConstants.IMAGE_PREFIX_URL + data.posterPath,
            contentDescription = null
        )

        Box(
            modifier = Modifier
                .align(Alignment.TopStart)
                .size(24.dp)
                .padding(4.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(MaterialTheme.colorScheme.primaryContainer),
            contentAlignment = Alignment.Center
        ) {
            val roundedVote = String.format("%.0f", data.voteAverage)
            Text(
                text = roundedVote,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer,
            )
        }
    }
}