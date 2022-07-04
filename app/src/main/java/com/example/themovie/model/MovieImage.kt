package com.example.themovie.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "movie_images")
data class MovieImage(
    @PrimaryKey val id:String = UUID.randomUUID().toString(),
    var movieId: String,
    var path:String) : Serializable
