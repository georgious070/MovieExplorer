package com.movie.moviewexplorer.di

import com.movie.data.MovieRepository
import com.movie.domain.GetDetailsUseCAse
import com.movie.domain.GetMoviesByQueryUseCase
import com.movie.domain.Repository
import com.movie.moviewexplorer.ui.base.BaseViewModel
import com.movie.moviewexplorer.ui.viewmodels.DetailsViewModel
import com.movie.moviewexplorer.ui.viewmodels.SearchMovieViewModel
import io.reactivex.Scheduler
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { SearchMovieViewModel(get()) }
    viewModel { DetailsViewModel(get()) }
}
val schedulersModule = module {
    single { schedulers() }
}

val implModule = module {
    single<Repository> { MovieRepository(get()) }
}

val useCaseModule = module {
    factory { GetMoviesByQueryUseCase(get()) }
    factory { GetDetailsUseCAse(get()) }
}

fun schedulers(): Map<BaseViewModel.SchedulerType, @JvmSuppressWildcards Scheduler> =
        mapOf(
                BaseViewModel.SchedulerType.WORK to BaseViewModel.SchedulerType.WORK.instantiateScheduler(),
                BaseViewModel.SchedulerType.MAIN to BaseViewModel.SchedulerType.MAIN.instantiateScheduler()
        )