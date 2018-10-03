package com.movie.domain

import com.movie.domain.models.Movie
import io.reactivex.Single

class GetMoviesByQueryUseCase(val repository: Repository){

    fun getMovies(query: String): Single<List<Movie>> =
            repository.getMovies(query)
}