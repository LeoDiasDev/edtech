package com.example.edtech.database.model

import android.content.Context
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.edtech.R

@Entity(
    indices = [Index(value = ["title"], unique = true)]
)
data class Movie(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "popularity") var popularity: Double?,
    @ColumnInfo(name = "vote_count") var vote_count: Int?,
    @ColumnInfo(name = "video") var video: Boolean?,
    @ColumnInfo(name = "poster_path") var poster_path: String?,
    @ColumnInfo(name = "adult") var adult: Boolean?,
    @ColumnInfo(name = "backdrop_path") var backdrop_path: String?,
    @ColumnInfo(name = "original_language") var original_language: String?,
    @ColumnInfo(name = "original_title") var original_title: String?,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "vote_average") var vote_average: Double?,
    @ColumnInfo(name = "overview") var overview: String?,
    @ColumnInfo(name = "release_date") var release_date: String?
) {
    override fun toString(): String {
        return "$title"
    }

    fun getFullUrl(context: Context): String? {
        return context.getString(R.string.URL_BASE_IMG) + backdrop_path
    }
}