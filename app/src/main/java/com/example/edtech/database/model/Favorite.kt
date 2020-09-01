package com.example.edtech.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [Index(value = ["nome"], unique = true)]
)
data class Favorite(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "nome") var nome: String?
) {
    override fun toString(): String {
        return "$nome"
    }
}