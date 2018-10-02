package com.movie.moviewexplorer.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import com.movie.moviewexplorer.ui.base.BaseViewModel

class SearchMovieViewModel : BaseViewModel() {

    val query = MutableLiveData<String>()

    fun findMovie(){
    }
}