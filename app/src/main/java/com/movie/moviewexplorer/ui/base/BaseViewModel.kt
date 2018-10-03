package com.movie.moviewexplorer.ui.base

import androidx.lifecycle.ViewModel
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

abstract class BaseViewModel : ViewModel() {

    val disposables = CompositeDisposable()

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }

    enum class SchedulerType(private val scheduler: Scheduler) {
        WORK(Schedulers.io()),
        MAIN(AndroidSchedulers.mainThread());

        fun instantiateScheduler(): Scheduler = scheduler
    }
}