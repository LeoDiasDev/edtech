package com.example.edtech.detail.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.edtech.common.model.Movies
import com.example.edtech.database.model.Movie
import com.example.edtech.detail.repository.DetailRepository
import com.example.edtech.main.repository.MainRepository

class DetailViewModel(private val repository: DetailRepository) : ViewModel() {

    fun fetchMoviesById(id: Long): LiveData<Movie> =
        repository.getMovieById(id)

}