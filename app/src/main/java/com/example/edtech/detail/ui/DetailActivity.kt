package com.example.edtech.detail.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.edtech.R
import com.example.edtech.database.AppDatabase
import com.example.edtech.detail.repository.DetailRepository
import com.example.edtech.detail.viewmodel.DetailViewModel
import com.example.edtech.detail.viewmodel.factory.DetailViewModelFactory

class DetailActivity : AppCompatActivity() {

    private var movieId : Long = 0

    private val viewModel by lazy {
        val factory =
            DetailViewModelFactory(
                DetailRepository(
                    AppDatabase.instance(this)
                )
            )
        ViewModelProvider(this, factory).get(DetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        movieId = intent.getLongExtra("movie_id", 0) as Long

        if(movieId > 0) { getData(movieId) }
    }

    fun getData(movieId: Long) {

      viewModel.fetchMoviesById(movieId).observe(this@DetailActivity, Observer {it ->

          Log.d("teste", ">$it")

      })

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}