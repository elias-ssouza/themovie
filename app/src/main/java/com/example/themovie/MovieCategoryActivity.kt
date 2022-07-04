package com.example.themovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themovie.adapter.MovieCategoryAdapter
import com.example.themovie.model.MovieCategory

class MovieCategoryActivity : AppCompatActivity(), MovieCategoryFragment.Callback {

    //lateinit var textTitle: TextView
    var isTablet: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_category)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        //textTitle.text = getString(R.string.movie_category_title)

        isTablet = findViewById<View>(R.id.fragment_movie)!= null
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun itemSelected(category: MovieCategory) {
        if (isTablet){
            val args = Bundle()
            args.putSerializable("CATEGORY", category)
            val fragment = MovieFragment()
            fragment.arguments = args
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_movie,fragment)
                .commit()
        }else{
            val intent = Intent(this,MovieActivity::class.java)
            intent.putExtra("CATEGORY", category)
            startActivity(intent)
        }
    }
}