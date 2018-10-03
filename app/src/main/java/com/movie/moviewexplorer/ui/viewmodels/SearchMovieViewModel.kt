package com.movie.moviewexplorer.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.movie.domain.GetMoviesByQueryUseCase
import com.movie.domain.models.Movie
import com.movie.moviewexplorer.ui.base.BaseViewModel

class SearchMovieViewModel(val getMoviesByQuery: GetMoviesByQueryUseCase) : BaseViewModel() {

    val query = MutableLiveData<String>()
    val setupAdapterEvent = MutableLiveData<List<Movie>>()

    fun findMovie() {
        getMoviesByQuery.getMovies(query.value ?: "AVENGERS")
                .subscribeOn(SchedulerType.WORK.instantiateScheduler())
                .observeOn(SchedulerType.MAIN.instantiateScheduler())
                .subscribe { r ->
                    setupAdapterEvent.postValue(r)
                }.let(disposables::add)
    }
}