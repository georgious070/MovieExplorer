package com.movie.data

import com.movie.domain.Repository
import com.movie.domain.models.Details
import com.movie.domain.models.Movie
import io.reactivex.Single

class MovieRepository(val api: TheMovieApi) : Repository {

    override fun getMovies(queryText: String): Single<List<Movie>> =
            api.getMoviesFromSearch(query = queryText)
                    .map { response ->
                        response.results?.map {
                            Movie(
                                    it.id,
                                    it.posterPath ?: "",
                                    it.title ?: "",
                                    it.releaseDate ?: ""
                            )
                        } ?: emptyList()
                    }

    override fun getDetails(id: Int): Single<Details> =
            api.getDetails(id)
                    .map {
                        Details(
                                it.backdropPath,
                                it.overview,
                                it.revenue,
                                it.runtime,
                                it.title,
                                it.voteAverage,
                                it.voteCount
                        )
                    }
}