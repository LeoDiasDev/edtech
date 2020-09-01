package com.example.edtech.main.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.edtech.common.model.Movies
import com.example.edtech.database.AppDatabase
import com.example.edtech.retrofit.webclient.WebClient

class MainRepository(val appDatabase: AppDatabase) {

    private val favoriteDao = appDatabase.favoriteDao()
    private val movieDao = appDatabase.movieDao()

    private val webClient by lazy {
        WebClient()
    }

    private val moviesLiveData = MutableLiveData<Movies>()

    fun getMovies() : LiveData<Movies> {
        webClient.getMovies(
            onSuccess = {
                it?.let { _ ->
                    movieDao.saveMovies(it.results)
                    moviesLiveData.value = it
                }
            },
            onFailure = {
                Log.d("teste", "teste")
            }
        )
        return moviesLiveData
    }
}