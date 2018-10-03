package com.movie.domain

import com.movie.domain.models.Details
import com.movie.domain.models.Movie
import io.reactivex.Single

interface Repository {
    fun getMovies(query:String):Single<List<Movie>>

    fun getDetails(id:Int): Single<Details>
}