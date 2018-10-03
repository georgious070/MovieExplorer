package com.movie.domain

import com.movie.domain.models.Details
import com.movie.domain.models.Movie
import io.reactivex.Single

class GetMoviesByQueryUseCase(private val repository: Repository){

    fun getMovies(query: String): Single<List<Movie>> =
            repository.getMovies(query)
}

class GetDetailsUseCAse(private val repository: Repository){

     fun getDetails(id: Int): Single<Details> =
             repository.getDetails(id)
}