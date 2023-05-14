package com.thiagoperea.filmfinder.ui.screens.movielist

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.thiagoperea.filmfinder.ui.screens.common.LoadingView
import com.thiagoperea.filmfinder.ui.screens.common.NoInfoFoundView
import org.koin.androidx.compose.koinViewModel

@Composable
fun MovieListScreen(
    viewModel: MovieListViewModel = koinViewModel()
) {
    val screenState = viewModel.screenState.value

    LaunchedEffect(Unit) {
        viewModel.loadInitialData()
    }

    when (screenState) {
        is MovieListState.Loading -> LoadingView()

        is MovieListState.Success -> MovieListScreenContent(
            movieList = screenState.movieList,
            categoryList = screenState.categories,
            selectedCategory = screenState.categorySelected,
            onItemClicked = { selectedMovie ->
                // navigate to details
            },
            onCategorySelected = { selectedCategory ->
                viewModel.loadMoviesFromCategory(selectedCategory)
            }
        )

        is MovieListState.Error -> NoInfoFoundView()
    }

}

