package com.thiagoperea.filmfinder.data.model

data class MovieVideosResponse(
    val results: List<MovieVideosItemResponse>
)

data class MovieVideosItemResponse(
    val site: String,
    val key: String
)