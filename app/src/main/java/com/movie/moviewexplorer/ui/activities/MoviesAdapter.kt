package com.movie.moviewexplorer.ui.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.movie.domain.models.Movie
import com.movie.moviewexplorer.BR
import com.movie.moviewexplorer.R

class MoviesAdapter(val clickMovie: (Int, List<Movie>) -> Unit) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private var movies = listOf<Movie>()

    fun updateAdapter(newMovies: List<Movie>) {
        val diffResult = DiffUtil.calculateDiff(BaseDiffUtilCallback(newMovies, movies))
        movies = newMovies
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = DataBindingUtil.inflate<ViewDataBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_movie,
                parent,
                false)
        return MovieViewHolder(binding.root).also { binding.setVariable(BR.viewModel, it) }
    }

    override fun getItemCount() = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.item.value = movies[position]
    }

    inner class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val item = MutableLiveData<Movie>()

        fun movieClick() {
            clickMovie(adapterPosition, movies)
        }
    }
}

class BaseDiffUtilCallback(
        private val newList: List<Movie>, private val oldList: List<Movie>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].id == newList[newItemPosition].id
}