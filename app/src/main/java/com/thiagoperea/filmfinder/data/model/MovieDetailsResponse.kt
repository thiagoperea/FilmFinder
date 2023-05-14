package com.thiagoperea.filmfinder.data.model

import com.google.gson.annotations.SerializedName

data class MovieDetailsResponse(
    val id: Long,
    @SerializedName("imdb_id") val imdbId: String,
    val overview: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String,
    val title: String,
    @SerializedName("vote_average") val voteAverage: Double
)