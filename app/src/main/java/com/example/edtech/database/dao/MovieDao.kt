package com.example.edtech.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.edtech.database.model.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM Movie")
    fun selectAllMovie(): List<Movie>

    @Query("SELECT * FROM Movie WHERE id = (:id)")
    fun getMoviesbyId(id: Long): LiveData<Movie>

    @Query("DELETE FROM Movie")
    fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovies(movie: List<Movie>)

    @Delete
    fun deleteMovie(movie: Movie)
}