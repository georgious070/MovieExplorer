package com.movie.moviewexplorer.ui.activities

import android.os.Bundle
import androidx.lifecycle.Observer
import com.movie.moviewexplorer.R
import com.movie.moviewexplorer.databinding.ActivitySearchMovieBinding
import com.movie.moviewexplorer.ui.base.BaseActivity
import com.movie.moviewexplorer.ui.models.MovieParcelable
import com.movie.moviewexplorer.ui.viewmodels.SearchMovieViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class SearchMovieActivity : BaseActivity<ActivitySearchMovieBinding, SearchMovieViewModel>() {

    override val layoutId = R.layout.activity_search_movie
    override val viewModel: SearchMovieViewModel by viewModel()
    private val adapter = MoviesAdapter { position, movies -> onMovieClick(position, movies) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.recycler.adapter = adapter
        viewModel.setupAdapterEvent.observe(this, Observer { adapter.updateAdapter(it) })
    }

    private fun onMovieClick(position: Int, movies: List<MovieParcelable>) {

    }
}
