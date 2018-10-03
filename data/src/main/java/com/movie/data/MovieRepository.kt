package com.movie.data

import com.movie.domain.Repository
import com.movie.domain.models.Movie
import io.reactivex.Single

class MovieRepository(val api: TheMovieApi) : Repository {

    override fun getMovies(queryText: String): Single<List<Movie>> =
            api.getMoviesFromSearch(query = queryText)
                    .map { response ->
                        response.results?.map {
                            Movie(
                                    it.id,
                                    it.poster_path ?: "",
                                    it.title ?: "",
                                    it.release_date ?: "")
                        } ?: emptyList()
                    }
}