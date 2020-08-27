package com.example.edtech

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.edtech.Utils.RemoveLastStr
import com.example.edtech.adapter.MovieAdapter
import com.example.edtech.model.Genre
import com.example.edtech.model.Genres
import com.example.edtech.model.Movie
import com.example.edtech.model.Movies
import com.example.edtech.rest.ApiService
import com.example.edtech.rest.NetworkUtils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailActivity : AppCompatActivity() {

    lateinit var movie : Movie

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        movie = intent.getParcelableExtra("movie") as Movie

        getGenres()
        getData()
    }

    fun getData() {

        //Capa do filme
        Picasso.get().load(movie.getFullUrl(this@DetailActivity)).into(cover_movie)

        //Titulo do filme
        title_movie.text = movie.title

        //Ano do filme
        year_movie.text = "("+Utils.getYearfromDate(movie.release_date)+")"

        //Data do filme
        date_release.text = Utils.getData(movie.release_date)

        //Sinopse do filme
        overview_text.text = movie.overview
    }

    private fun getGenres() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance(this@DetailActivity)

        val endpoint = retrofitClient.create(ApiService::class.java)
        val callback = endpoint.getGenres()
        callback.enqueue(object : Callback<Genres> {
            override fun onFailure(call: Call<Genres>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Genres>, response: Response<Genres>) {
                response.body()?.genres?.forEach { genre ->
                    movie.genre_ids.forEach{genre_id ->
                        //Generos do filme
                        if(genre_id == genre.id){
                            genres.text = genres.text.toString().plus(genre.name).plus(", ")
                        }
                    }
                }
                genres.text = genres.text.toString().substring(0, (genres.text.toString().length - 2))
            }
        })
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}