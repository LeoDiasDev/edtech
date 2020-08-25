package com.example.edtech.rest

import com.example.edtech.model.Movies
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/3/movie/upcoming")
    fun getMovies(@Query("api_key") api_key: String) : Call<Movies>

}