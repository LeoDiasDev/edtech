package com.example.edtech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.edtech.adapter.MovieAdapter
import com.example.edtech.model.Movies
import com.example.edtech.rest.ApiService
import com.example.edtech.rest.NetworkUtils
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }

    fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance(this@MainActivity)

        val endpoint = retrofitClient.create(ApiService::class.java)
        val callback = endpoint.getMovies()

        callback.enqueue(object : Callback<Movies> {
            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<Movies>, response: Response<Movies>) {

                recyclerView.adapter = MovieAdapter(response.body()!!.results, this@MainActivity)
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

            }
        })

    }
}