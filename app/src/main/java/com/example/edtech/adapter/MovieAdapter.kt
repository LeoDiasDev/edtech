package com.example.edtech.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.edtech.DetailActivity
import com.example.edtech.MainActivity
import com.example.edtech.R
import com.example.edtech.model.Movie
import kotlinx.android.synthetic.main.item_custom_movie.view.*

class MovieAdapter(
    private val movies: List<Movie>,
    val context: Context
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

            itemView.setOnClickListener{
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("movie", movie)
                context.startActivity(intent)
            }
        }
    }
}