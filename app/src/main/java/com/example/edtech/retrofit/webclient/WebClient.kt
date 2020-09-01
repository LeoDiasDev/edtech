package com.example.edtech.retrofit.webclient

import com.example.edtech.common.model.Movies
import com.example.edtech.retrofit.NetworkUtils

class WebClient() : BaseClient() {

    private val service by lazy {
        NetworkUtils().service
    }

    fun getMovies(
        onSuccess: (moviesResponse: Movies?) -> Unit,
        onFailure: (error: String?) -> Unit
    ) {
        doRequest(service.getMovies(), onSuccess, onFailure)
    }
}