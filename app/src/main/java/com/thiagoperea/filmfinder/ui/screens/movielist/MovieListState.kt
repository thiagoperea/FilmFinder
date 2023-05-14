package com.thiagoperea.filmfinder.ui.screens.movielist

import com.thiagoperea.filmfinder.data.model.MovieCategories
import com.thiagoperea.filmfinder.data.model.MovieListItemResponse

sealed class MovieListState {

    object Loading : MovieListState()

    data class Success(
        val categories: List<MovieCategories>,
        val categorySelected: MovieCategories,
        val movieList: List<MovieListItemResponse>,
    ) : MovieListState()

    data class Error(val errorMessage: String) : MovieListState()
}