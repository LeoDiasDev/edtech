package com.example.edtech.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.edtech.R
import com.example.edtech.common.extensions.getData
import com.example.edtech.database.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_custom_movie.view.*

class MovieAdapter(
    private val movies: List<Movie>,
    val context: Context,
    private val detalhesListener: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_custom_movie, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(movies[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(movie: Movie) {

            itemView.name.text = movie.title

            Picasso.get().load(movie.getFullUrl(context)).into(itemView.cover_movie)

            itemView.release.text = context.getData(movie.release_date!!)

            itemView.setOnClickListener { detalhesListener(movie) }

        }
    }
}