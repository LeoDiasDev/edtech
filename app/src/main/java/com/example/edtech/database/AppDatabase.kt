package com.example.edtech.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.edtech.database.dao.FavoriteDao
import com.example.edtech.database.dao.MovieDao
import com.example.edtech.database.model.Favorite
import com.example.edtech.database.model.Movie

const val DATABASE_NAME = "database.db"

@Database(
    entities = [
        Favorite::class,
        Movie::class
    ],
    version = 1, exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun favoriteDao(): FavoriteDao
    abstract fun movieDao(): MovieDao

    companion object Database {

        private lateinit var database: AppDatabase

        fun instance(context: Context): AppDatabase {
            if (::database.isInitialized) return database
            return Room
                .databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
//                .addMigrations(*ALL_MIGRATIONS)
                .build()
        }

    }
}