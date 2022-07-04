package com.example.themovie.model

import androidx.room.Embedded
import androidx.room.Relation


data class CategoryWithMovies(
    @Embedded val category: MovieCategory,
    @Relation(
        parentColumn = "id",
        entityColumn = "categoryId"
    )
    val movies: List<Movie>)
