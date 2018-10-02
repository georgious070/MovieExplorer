package com.movie.moviewexplorer.ui.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.movie.moviewexplorer.ui.models.MovieParcelable

class MoviesAdapter(val clickMovie: (Int, List<MovieParcelable>) -> Unit) : RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    private var movies = listOf<MovieParcelable>()

    fun updateAdapter(newMovies: List<MovieParcelable>) {
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

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) =
            holder.item.postValue(movies[position])

    inner class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val item = MutableLiveData<MovieParcelable>()

        fun movieClick() {
            clickMovie(adapterPosition, movies)
        }
    }
}

class BaseDiffUtilCallback(
        private val newList: List<MovieParcelable>, private val oldList: List<MovieParcelable>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition].title == newList[newItemPosition].title

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldList[oldItemPosition] === newList[newItemPosition]
}