package com.thiagoperea.filmfinder.di

import com.thiagoperea.filmfinder.data.remote.TmdbApi
import com.thiagoperea.filmfinder.data.remote.callWithApiKey
import com.thiagoperea.filmfinder.data.repository.MovieRepository
import com.thiagoperea.filmfinder.ui.screens.moviedetails.MovieDetailsViewModel
import com.thiagoperea.filmfinder.ui.screens.movielist.MovieListViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val datasourceModule = module {

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(
                OkHttpClient()
                    .newBuilder()
                    .addInterceptor { it.callWithApiKey() }
                    .addInterceptor(HttpLoggingInterceptor().apply { this.level = HttpLoggingInterceptor.Level.BODY })
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return@single retrofit.create(TmdbApi::class.java)
    }
}

val repositoryModule = module {

    single { MovieRepository(get()) }
}

val viewModelModule = module {

    viewModel { MovieListViewModel(get()) }

    viewModel { MovieDetailsViewModel(get()) }
}