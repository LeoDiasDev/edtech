package com.example.edtech.model

import android.content.Context
import android.os.Parcelable
import com.example.edtech.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (

    val popularity : Double,
    val vote_count : Int,
    val video : Boolean,
    val poster_path : String,
    val id : Long,
    val adult : Boolean,
    val backdrop_path : String,
    val original_language : String,
    val original_title : String,
    val genre_ids : List<Int>,
    val title : String,
    val vote_average : Double,
    val overview : String,
    val release_date : String

) : Parcelable
{
    fun getFullUrl(context: Context): String? {
        return context.getString(R.string.URL_BASE_IMG) + backdrop_path
    }
}


