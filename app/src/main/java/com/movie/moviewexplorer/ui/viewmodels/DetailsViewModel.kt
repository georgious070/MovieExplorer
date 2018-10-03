package com.movie.moviewexplorer.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.movie.domain.GetDetailsUseCAse
import com.movie.moviewexplorer.ui.base.BaseViewModel

class DetailsViewModel(private val getDetails: GetDetailsUseCAse) : BaseViewModel() {

    val backdropPath = MutableLiveData<String>()
    val overview = MutableLiveData<String>()
    val revenue = MutableLiveData<Int>()
    val runtime = MutableLiveData<Int>()
    val title = MutableLiveData<String>()
    val voteAverage = MutableLiveData<Double>()
    val voteCount = MutableLiveData<Int>()

    fun getMovieDetails(id: Int) {
        getDetails.getDetails(id)
                .subscribeOn(SchedulerType.WORK.instantiateScheduler())
                .observeOn(SchedulerType.MAIN.instantiateScheduler())
                .subscribe({
                    backdropPath.value = it.backdropPath
                    overview.value = it.overview
                    revenue.value = it.revenue
                    runtime.value = it.runtime
                    title.value = it.title
                    voteAverage.value = it.voteAverage
                    voteCount.value = it.voteCount
                }, { /*handle errors here */ })
                .let(disposables::add)
    }
}