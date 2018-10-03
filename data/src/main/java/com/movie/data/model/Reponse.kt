package com.movie.data.model

import com.google.gson.annotations.SerializedName

data class MainInfoResponse(
        @SerializedName("results")
        val results: List<MovieResponse>? = emptyList()
)

data class MovieResponse(
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String?,
        @SerializedName("poster_path")
        val posterPath: String?,
        @SerializedName("release_date")
        val releaseDate: String?
)

data class DetailsInfoResponse(
        @SerializedName("backdrop_path")
        val backdropPath: String,
        @SerializedName("overview")
        val overview: String,
        @SerializedName("revenue")
        val revenue: Int,
        @SerializedName("runtime")
        val runtime: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("vote_average")
        val voteAverage: Double,
        @SerializedName("vote_count")
        val voteCount: Int
)