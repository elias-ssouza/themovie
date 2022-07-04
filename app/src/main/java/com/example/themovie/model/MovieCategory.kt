package com.example.themovie.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity (tableName = "movie_categories")
data class MovieCategory(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    var title: String,
    var featured:Boolean = false) : Serializable


