package com.thiagoperea.filmfinder.data.model

import com.google.gson.annotations.SerializedName

data class MovieCastResponse(
    val cast: List<MovieCastItemResponse>
)

data class MovieCastItemResponse(
    val name: String,
    val character: String,
    @SerializedName("profile_path") val profilePath: String
)