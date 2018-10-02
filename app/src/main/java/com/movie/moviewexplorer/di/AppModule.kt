package com.movie.moviewexplorer.di

import com.movie.moviewexplorer.ui.viewmodels.SearchMovieViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { SearchMovieViewModel() }
}