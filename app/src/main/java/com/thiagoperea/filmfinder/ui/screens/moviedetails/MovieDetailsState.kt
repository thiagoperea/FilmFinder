package com.thiagoperea.filmfinder.ui.screens.moviedetails

import com.thiagoperea.filmfinder.data.model.MovieCastResponse
import com.thiagoperea.filmfinder.data.model.MovieDetailsResponse
import com.thiagoperea.filmfinder.data.model.MovieVideosResponse

sealed class MovieDetailsState {

    object Loading : MovieDetailsState()

    data class Success(
        val movieDetails: MovieDetailsResponse,
        val castData: MovieCastResponse,
        val movieVideos: MovieVideosResponse
    ) : MovieDetailsState()

    data class Error(val errorMessage: String) : MovieDetailsState()
}