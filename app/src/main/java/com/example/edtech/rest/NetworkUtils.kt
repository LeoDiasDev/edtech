package com.example.edtech.rest

import android.content.Context
import com.example.edtech.R
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkUtils {
    companion object {
        fun getRetrofitInstance(context: Context) : Retrofit {

            return Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/")
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor { chain ->
                            val url = chain
                                .request()
                                .url()
                                .newBuilder()
                                .addQueryParameter("api_key", "be1337d353cc4f164a071672021ad102")
                                .addQueryParameter("language", "pt-BR")
                                .build()
                            chain.proceed(chain.request().newBuilder().url(url).build())
                        }
                        .build()
                )
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}

