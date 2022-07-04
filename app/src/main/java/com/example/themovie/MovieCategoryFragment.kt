package com.example.themovie

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themovie.adapter.MovieCategoryAdapter
import com.example.themovie.model.MovieCategory

class MovieCategoryFragment: Fragment() {

    lateinit var recyclerCategory: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view: View = inflater.inflate(R.layout.fragment_movie_category, container)

        recyclerCategory = view.findViewById(R.id.rv_movie_category)

        val arrayCategory = arrayListOf<MovieCategory>(
            MovieCategory("1", "Ação", MainActivity().fillRvMovie()),
            MovieCategory("2", "Drama", MainActivity().fillRvMovie()),
            MovieCategory("3", "Comédia", MainActivity().fillRvMovie()),
            MovieCategory("4", "Ficção Científica", MainActivity().fillRvMovie())
        )

        val adapterCategory = MovieCategoryAdapter(arrayCategory, requireContext())

        recyclerCategory.adapter = adapterCategory
        recyclerCategory.layoutManager = GridLayoutManager(requireContext(), 2)
        return view
    }
    interface Callback{
        fun itemSelected(category: MovieCategory)
    }

}