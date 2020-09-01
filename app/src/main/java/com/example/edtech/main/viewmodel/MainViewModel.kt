package com.example.edtech.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.edtech.common.model.Movies
import com.example.edtech.main.repository.MainRepository

class MainViewModel(private val repository: MainRepository) : ViewModel() {

    fun fetchMoviesList(): LiveData<Movies> =
        repository.getMovies()

}