package com.example.themovie.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "languages")
data class MovieLanguage(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    var language: String) : Serializable
