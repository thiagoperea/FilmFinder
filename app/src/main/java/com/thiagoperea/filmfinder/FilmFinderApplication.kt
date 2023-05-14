package com.thiagoperea.filmfinder

import android.app.Application
import com.thiagoperea.filmfinder.di.datasourceModule
import com.thiagoperea.filmfinder.di.repositoryModule
import com.thiagoperea.filmfinder.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class FilmFinderApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FilmFinderApplication)
            modules(datasourceModule, repositoryModule, viewModelModule)
        }
    }
}