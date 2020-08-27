package com.example.edtech.rest

import com.example.edtech.model.Genre
import com.example.edtech.model.Genres
import com.example.edtech.model.Movies
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/3/movie/upcoming")
    fun getMovies() : Call<Movies>

    @GET("/3/genre/movie/list")
    fun getGenres() : Call<Genres>

}