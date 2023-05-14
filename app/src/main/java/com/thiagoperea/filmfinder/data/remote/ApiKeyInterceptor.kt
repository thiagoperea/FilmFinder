package com.thiagoperea.filmfinder.data.remote

import okhttp3.Interceptor
import okhttp3.Response

fun Interceptor.Chain.callWithApiKey(): Response = this.proceed(
    this.request()
        .newBuilder()
        .url(this.request().url().newBuilder().addQueryParameter("api_key", "ac1c767e6fd96f9b634e0adad258128b").build())
        .build()
)