package com.example.edtech.main.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.edtech.detail.ui.DetailActivity
import com.example.edtech.R
import com.example.edtech.main.adapter.MovieAdapter
import com.example.edtech.database.AppDatabase
import com.example.edtech.main.repository.MainRepository
import com.example.edtech.main.viewmodel.MainViewModel
import com.example.edtech.main.viewmodel.factory.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        val factory =
            MainViewModelFactory(
                MainRepository(
                    AppDatabase.instance(this)
                )
            )
        ViewModelProvider(this, factory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()
    }

    private fun initList() {
        viewModel.fetchMoviesList().observe(this, Observer {
            it?.let{
                if(it.results.isNotEmpty()){
                    recyclerView.adapter = MovieAdapter(
                        it.results,
                        this@MainActivity,
                        detalhesListener = {
                            movie ->

                            val intent = Intent(this@MainActivity, DetailActivity::class.java)
                            intent.putExtra("movie_id", movie.id)
                            intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
                            startActivity(intent)
                        })
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }
        })
    }
}