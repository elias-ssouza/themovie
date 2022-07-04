package com.example.themovie.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.themovie.MovieCategoryFragment
import com.example.themovie.MovieDetailActivity
import com.example.themovie.R
import com.example.themovie.model.Movie
import com.example.themovie.model.MovieCategory


class MovieCategoryAdapter(val list: List<MovieCategory>, val context: Context) : RecyclerView.Adapter<MovieCategoryAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie_category, parent, false)
// guarda o icon e o title e retorna
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category: MovieCategory = list [position]
        //jogando os dados da categoria dentro do viewholder
        holder.title.text = category.title
        holder.cardView.setOnClickListener{
            (context as MovieCategoryFragment.Callback).itemSelected(category)
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(var itemView: View) :RecyclerView.ViewHolder(itemView){
        val icon: ImageView = itemView.findViewById(R.id.iv_category_icon)
        val title: TextView = itemView.findViewById(R.id.tv_category_title)
        val cardView: CardView = itemView.findViewById(R.id.cv_movie_category)
    }
}