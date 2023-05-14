package com.thiagoperea.filmfinder.di

import com.thiagoperea.filmfinder.data.remote.TmdbApi
import com.thiagoperea.filmfinder.data.remote.callWithApiKey
import com.thiagoperea.filmfinder.data.repository.MovieRepository
import com.thiagoperea.filmfinder.ui.screens.movielist.MovieListViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val datasourceModule = module {

    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .client(
                OkHttpClient()
                    .newBuilder()
                    .addInterceptor { it.callWithApiKey() }
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
}