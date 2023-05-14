package com.thiagoperea.filmfinder.data.remote

import com.thiagoperea.filmfinder.data.model.MovieCastResponse
import com.thiagoperea.filmfinder.data.model.MovieDetailsResponse
import com.thiagoperea.filmfinder.data.model.MovieListResponse
import com.thiagoperea.filmfinder.data.model.MovieVideosResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface TmdbApi {

    @GET("movie/{category}")
    suspend fun getMovieListByCategory(@Path("category") category: String): MovieListResponse

    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(@Path("movie_id") movieId: Long): MovieDetailsResponse

    @GET("movie/{movie_id}/videos")
    suspend fun getMovieVideosData(@Path("movie_id") movieId: Long): MovieVideosResponse

    @GET("movie/{movie_id}/credits")
    suspend fun getMovieCast(@Path("movie_id") movieId: Long): MovieCastResponse
}