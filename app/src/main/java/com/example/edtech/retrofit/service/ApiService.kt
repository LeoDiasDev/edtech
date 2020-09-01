package com.example.edtech.retrofit.service

import com.example.edtech.common.model.Genres
import com.example.edtech.common.model.Movies
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/3/movie/upcoming")
    fun getMovies() : Call<Movies>

    @GET("/3/genre/movie/list")
    fun getGenres() : Call<Genres>

}