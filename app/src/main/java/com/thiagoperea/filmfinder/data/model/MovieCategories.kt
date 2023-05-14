package com.thiagoperea.filmfinder.data.model

import com.thiagoperea.filmfinder.R

enum class MovieCategories(val urlQuery: String, val stringRes: Int) {
    LATEST("latest", R.string.latest),
    NOW_PLAYING("now_playing", R.string.now_playing),
    POPULAR("popular", R.string.popular),
    TOP_RATED("top_rated", R.string.top_rated),
    UPCOMING("upcoming", R.string.upcoming),
}