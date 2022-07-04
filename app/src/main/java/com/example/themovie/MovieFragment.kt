package com.example.themovie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.themovie.adapter.MovieAdapter
import com.example.themovie.model.Movie
import com.example.themovie.model.MovieCategory


class MovieFragment : Fragment() {
    lateinit var recyclerMovie: RecyclerView
    lateinit var  arrayMovie: List<Movie>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments!=null){
            arrayMovie = (arguments?.getSerializable("CATEGORY") as MovieCategory).movies

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_movie, container,false)

        recyclerMovie = view.findViewById(R.id.rv_movie)

        val adapterProduct = MovieAdapter(arrayMovie, requireContext())

        recyclerMovie.adapter = adapterProduct
        recyclerMovie.layoutManager = GridLayoutManager(requireContext(),3)

        return view

    }

}