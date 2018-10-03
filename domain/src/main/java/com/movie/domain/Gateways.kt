package com.movie.domain

import com.movie.domain.models.Movie
import io.reactivex.Single

interface Repository {
    fun getMovies(query:String):Single<List<Movie>>
}