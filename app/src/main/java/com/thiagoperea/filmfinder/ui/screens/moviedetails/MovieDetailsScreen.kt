package com.thiagoperea.filmfinder.ui.screens.moviedetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.thiagoperea.filmfinder.ui.screens.common.LoadingView
import com.thiagoperea.filmfinder.ui.screens.common.NoInfoFoundView
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: MovieDetailsViewModel = koinViewModel()
){
    val movieId = 0L

    val screenState = viewModel.screenState.value

    LaunchedEffect(Unit){
        viewModel.loadMovieDetails(movieId)
    }

    when(screenState){
        is MovieDetailsState.Loading -> LoadingView()
        is MovieDetailsState.Success -> MovieDetailsScreenContent(
            details = screenState.movieDetails,
            cast = screenState.castData,
            videos = screenState.movieVideos
        )
        is MovieDetailsState.Error -> NoInfoFoundView()
    }
}