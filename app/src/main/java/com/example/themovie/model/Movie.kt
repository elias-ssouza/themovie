package com.example.themovie.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "movies")
data class Movie(
    @PrimaryKey var id: String = UUID.randomUUID().toString(),
    var title: String,
    var categoryId: String,
    var description: String,
    var thumbnail: String,
    var feature: Boolean) : Serializable

