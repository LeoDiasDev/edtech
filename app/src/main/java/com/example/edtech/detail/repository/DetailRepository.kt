package com.example.edtech.detail.repository

import androidx.lifecycle.LiveData
import com.example.edtech.database.AppDatabase
import com.example.edtech.database.model.Movie

class DetailRepository(appDatabase: AppDatabase) {

    private val movieDao = appDatabase.movieDao()

    fun getMovieById(id: Long) : LiveData<Movie>  = movieDao.getMoviesbyId(id)
}