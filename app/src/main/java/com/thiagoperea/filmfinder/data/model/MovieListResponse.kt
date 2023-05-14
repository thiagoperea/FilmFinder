package com.thiagoperea.filmfinder.data.model

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    val page: Int,
    val results: List<MovieListItemResponse>?,
    @SerializedName("total_pages") val totalPages: Int
)

data class MovieListItemResponse(
    val id: Long,
    @SerializedName("poster_path") val posterPath: String,
    val title: String,
    @SerializedName("vote_average") val voteAverage: Double
)