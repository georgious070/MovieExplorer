package com.movie.moviewexplorer.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.movie.moviewexplorer.R
import com.movie.moviewexplorer.databinding.ActivityDetailsBinding
import com.movie.moviewexplorer.ui.base.BaseActivity
import com.movie.moviewexplorer.ui.viewmodels.DetailsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class DetailsActivity : BaseActivity<ActivityDetailsBinding, DetailsViewModel>() {

    companion object {
        private const val ARG_MOVIE_ID_KEY = "ARG_MOVIE_ID_KEY"

        fun newIntent(context: Context, id: Int) =
                Intent(context, DetailsActivity::class.java)
                        .apply { putExtra(ARG_MOVIE_ID_KEY, id) }
    }

    override val layoutId = R.layout.activity_details
    override val viewModel: DetailsViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getMovieDetails(intent.getIntExtra(ARG_MOVIE_ID_KEY, 0))
    }
}