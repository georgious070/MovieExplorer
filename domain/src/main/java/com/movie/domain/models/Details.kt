package com.movie.domain.models

data class Details(
        val backdropPath: String,
        val overview: String,
        val revenue: Int,
        val runtime: Int,
        val title: String,
        val voteAverage: Double,
        val voteCount: Int
)