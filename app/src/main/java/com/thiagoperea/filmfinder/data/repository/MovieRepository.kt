package com.thiagoperea.filmfinder.data.repository

import com.thiagoperea.filmfinder.data.model.MovieCategories
import com.thiagoperea.filmfinder.data.remote.TmdbApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(val api: TmdbApi) {

    fun getCategories() = listOf(
        MovieCategories.NOW_PLAYING,
        MovieCategories.POPULAR,
        MovieCategories.TOP_RATED,
        MovieCategories.UPCOMING
    )

    suspend fun getAllMovies(categoryUrl: String) = withContext(Dispatchers.IO) {
        api.getMovieListByCategory(categoryUrl)
    }

}