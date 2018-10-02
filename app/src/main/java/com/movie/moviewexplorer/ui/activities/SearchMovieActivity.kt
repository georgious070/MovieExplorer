package com.movie.moviewexplorer.ui.activities

import android.os.Bundle
import com.movie.moviewexplorer.databinding.ActivitySearchMovieBinding
import com.movie.moviewexplorer.ui.base.BaseActivity
import com.movie.moviewexplorer.ui.models.MovieParcelable
import com.movie.moviewexplorer.ui.viewmodels.SearchMovieViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SearchMovieActivity : BaseActivity<ActivitySearchMovieBinding, SearchMovieViewModel>() {

    override val layoutId = R.layout.activity_search_movie
    override val viewModel: SearchMovieViewModel by viewModel()
    val adapter get() = MoviesAdapter { position, movies -> onMovieClick(position, movies) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.recyclerView.adapter = adapter
    }

    fun onMovieClick(position: Int, movies: List<MovieParcelable>) {
        // todo start second activity
    }
}
