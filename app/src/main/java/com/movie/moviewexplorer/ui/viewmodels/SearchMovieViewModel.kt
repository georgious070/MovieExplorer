package com.movie.moviewexplorer.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.movie.domain.GetMoviesByQueryUseCase
import com.movie.moviewexplorer.ui.base.BaseViewModel
import com.movie.moviewexplorer.ui.models.MovieParcelable

class SearchMovieViewModel(val getMoviesByQuery: GetMoviesByQueryUseCase) : BaseViewModel() {

    val query = MutableLiveData<String>()
    val setupAdapterEvent = MutableLiveData<List<MovieParcelable>>()

    fun findMovie() {
        getMoviesByQuery.getMovies(query.value ?: "AVENGERS")
                .subscribeOn(SchedulerType.WORK.instantiateScheduler())
                .observeOn(SchedulerType.MAIN.instantiateScheduler())
                .subscribe { result ->
                    setupAdapterEvent.postValue(result.map { MovieParcelable(it.poster, it.title, it.year) })
                }.let(disposables::add)
    }
}