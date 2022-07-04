package com.example.themovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.themovie.model.MovieCategory

class MovieActivity : AppCompatActivity() {

    lateinit var textTitle: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)


        textTitle.text = getString(R.string.movie_title)

        val category = intent.getSerializableExtra("CATEGORY") as MovieCategory

        val args = Bundle()
        args.putSerializable("CATEGORY", category)
        val fragment = MovieFragment()
        fragment.arguments = args
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_movie,fragment)
            .commit()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}