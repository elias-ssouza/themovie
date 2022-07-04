package com.example.themovie.model

import androidx.room.Embedded
import androidx.room.Relation

data class MovieVariants(
    @Embedded val movie: Movie,
    @Relation(
        parentColumn = "id",
        entityColumn = "movieId"
    )
    val year: List<MovieYear>,
    @Relation(
        parentColumn = "id",
        entityColumn = "movieId"
    )
    val language: List<MovieLanguage>,
    @Relation(
        parentColumn = "id",
        entityColumn = "movieId"
    )
        val images: List<MovieImage>)

