package com.movie.data

import com.movie.data.model.DetailsInfoResponse
import com.movie.data.model.MainInfoResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface TheMovieApi {

    companion object {
        const val API_KEY = "83d01f18538cb7a275147492f84c3698"
    }

    @GET("search/movie")
    fun getMoviesFromSearch(@Query("api_key") apiKey: String = API_KEY,
                            @Query("query") query: String): Single<MainInfoResponse>

    @GET("movie/{movie_id}")
    fun getDetails(@Path("movie_id") id:Int,
                   @Query("api_key") apiKey: String = API_KEY) : Single<DetailsInfoResponse>
}