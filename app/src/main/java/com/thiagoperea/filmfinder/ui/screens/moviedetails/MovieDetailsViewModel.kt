package com.thiagoperea.filmfinder.ui.screens.moviedetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thiagoperea.filmfinder.data.repository.MovieRepository
import kotlinx.coroutines.launch

class MovieDetailsViewModel(
    val repository: MovieRepository
) : ViewModel() {

    val screenState = mutableStateOf<MovieDetailsState>(MovieDetailsState.Loading)

    fun loadMovieDetails(movieId: Long) {

        viewModelScope.launch {

            try {
                val details = repository.getMovieDetails(movieId)

                val castData = repository.getMovieCastData(movieId)

                val movieVideosData = repository.getMovieVideoData(movieId)

                screenState.value = MovieDetailsState.Success(
                    movieDetails = details,
                    castData = castData,
                    movieVideos = movieVideosData
                )

            } catch (error: Exception) {
                screenState.value = MovieDetailsState.Error(error.message.orEmpty())
            }
        }
    }
}