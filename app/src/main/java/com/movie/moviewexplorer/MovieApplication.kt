package com.movie.moviewexplorer

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.movie.data.di.apiModule
import com.movie.moviewexplorer.di.implModule
import com.movie.moviewexplorer.di.schedulersModule
import com.movie.moviewexplorer.di.useCaseModule
import com.movie.moviewexplorer.di.viewModelModule
import org.koin.android.ext.android.startKoin

class MovieApplication : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(viewModelModule, apiModule, implModule, schedulersModule, useCaseModule))
    }
}