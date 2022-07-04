package com.example.themovie.model

import androidx.room.Entity
import java.io.Serializable
import java.util.*

@Entity (tableName = "movie_year")
data class MovieYear(
    val id: String = UUID.randomUUID().toString(),
    var year: Int,) : Serializable


