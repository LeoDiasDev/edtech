package com.example.edtech.database.dao

import androidx.room.*
import com.example.edtech.database.model.Favorite

@Dao
interface FavoriteDao {
    @Query("SELECT * FROM Favorite")
    fun selectAllFavorites(): List<Favorite>

    @Query("DELETE FROM Favorite")
    fun clearTable()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveFavorite(favorite: Favorite)

    @Delete
    fun deleteFavorite(favorite: Favorite)
}