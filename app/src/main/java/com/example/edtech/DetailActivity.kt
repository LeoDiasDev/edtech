package com.example.edtech

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.edtech.model.Movie

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        getData()
    }

    fun getData() {

        val movie: Movie = intent.getParcelableExtra("movie")
        Log.d("movie", ">$movie")

    }

}