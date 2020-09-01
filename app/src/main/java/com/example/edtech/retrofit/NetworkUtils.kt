package com.example.edtech.retrofit

import com.example.edtech.retrofit.service.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://api.themoviedb.org/"
const val API_KEY = "be1337d353cc4f164a071672021ad102"
const val LANGUAGE = "pt-BR"

class NetworkUtils {

    private val client by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor{chain ->

                val url = chain
                    .request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("api_key", API_KEY)
                    .addQueryParameter("language", LANGUAGE)
                    .build()
                chain.proceed(chain.request().newBuilder().url(url).build())

            }
            .build()
    }

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val service: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}

