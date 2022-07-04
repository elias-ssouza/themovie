package com.example.themovie

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themovie.adapter.MovieAdapter
import com.example.themovie.adapter.MovieCategoryAdapter
import com.google.android.material.navigation.NavigationView
import com.example.themovie.model.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, MovieCategoryFragment.Callback
{


    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView
    lateinit var recyclerCategory: RecyclerView
    lateinit var recyclerMovie: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        drawerLayout = findViewById(R.id.nav_drawer_layout)

        val toggle: ActionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.toogle_open,
            R.string.toogle_close
        )
        drawerLayout.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        toggle.syncState()

        navigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)


        recyclerCategory = findViewById(R.id.rv_movie_category)

        val arrayCategory = arrayListOf<MovieCategory>(
            MovieCategory("1", "Ação", fillRvMovie()),
            MovieCategory("2", "Drama", fillRvMovie()),
            MovieCategory("3", "Comédia", fillRvMovie()),
            MovieCategory("4", "Ficção Científica", fillRvMovie())
        )

        val adapterCategory = MovieCategoryAdapter(arrayCategory, this)

        recyclerCategory.adapter = adapterCategory
        recyclerCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerMovie = findViewById(R.id.rv_product)

        val adapterMovie = MovieAdapter(fillRvMovie(), this)

        recyclerMovie.adapter = adapterMovie
        recyclerMovie.layoutManager = LinearLayoutManager(this,  LinearLayoutManager.HORIZONTAL, false)

    }

        fun fillRvMovie(): List<Movie> {

            val movie1: Movie = Movie(
                "1",
                "Mortal Kombat",
                MovieCategory("1","Ação"),
                "Muita ação e pancadaria",
                2020,
                arrayListOf(MovieLanguage("1"), MovieLanguage("2")),
                emptyList()
            )

            val movie2: Movie = Movie(
                "1",
                "Street Fighter",
                MovieCategory("1","Ação"),
                "Muita ação e pancadaria",
                2019,
                arrayListOf(MovieLanguage("1"), MovieLanguage("2")),
                emptyList()
            )

            return arrayListOf(movie1, movie2)
        }

        override fun onBackPressed() {

            if (drawerLayout.isDrawerOpen(GravityCompat.START))
                drawerLayout.closeDrawer(GravityCompat.START)
            else
                super.onBackPressed()
        }

        override fun onNavigationItemSelected(item: MenuItem): Boolean {

            when (item.itemId) {
                R.id.nav_home -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_category -> {
                    val intent = Intent(this, MovieCategoryActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_settings -> {
                    val intent = Intent(this, SettingsActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_logout -> Toast.makeText(this, "Sair", Toast.LENGTH_LONG).show()
            }

            drawerLayout.closeDrawer(GravityCompat.START)

            return true
        }

    override fun itemSelected(category: MovieCategory) {
        val intent = Intent(this, MovieCategoryActivity::class.java)
        intent.putExtra("CATEGORY", category)
        startActivity(intent)
    }
}
