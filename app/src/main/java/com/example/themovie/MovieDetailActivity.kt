package com.example.themovie

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.example.themovie.model.Movie
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class MovieDetailActivity : AppCompatActivity() {

    //lateinit var textTitle: TextView
    lateinit var movie: Movie
    lateinit var movieDescription: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        movie = intent.getSerializableExtra("MOVIE") as Movie

        //textTitle.text = movie.title

        movieDescription = findViewById(R.id.tv_movie_description)
        movieDescription.text = movie.description


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}