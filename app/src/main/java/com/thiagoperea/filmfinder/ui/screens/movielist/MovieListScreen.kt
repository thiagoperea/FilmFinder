package com.thiagoperea.filmfinder.ui.screens.movielist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.thiagoperea.filmfinder.ui.screens.common.LoadingView
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieListScreen(
    modifier: Modifier = Modifier,
    viewModel: MovieListViewModel = koinViewModel()
) {
    val screenState = viewModel.screenState.value
    val screenEvent = viewModel.screenEvent.value

    LaunchedEffect(Unit) {
        viewModel.loadInitialData()
    }

    when (screenEvent) {
        MovieListEvent.Idle -> Unit
    }

    when (screenState) {
        is MovieListState.Loading -> LoadingView()

        is MovieListState.Success -> MovieListScreenContent(
            movieList = screenState.movieList
        )

        is MovieListState.Error -> MovieListScreenContent(
            movieList = emptyList()
        )
    }

}

