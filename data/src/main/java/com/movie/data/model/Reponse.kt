package com.movie.data.model

import com.google.gson.annotations.SerializedName

data class MainInfo(
        @SerializedName("results")
        val results: List<MovieResponse>? = emptyList()
)

data class MovieResponse(
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String?,
        @SerializedName("poster_path")
        val poster_path: String?,
        @SerializedName("release_date")
        val release_date: String?
)