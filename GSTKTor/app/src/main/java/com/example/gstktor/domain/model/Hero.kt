package com.example.gstktor.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.gstktor.util.Constants.HERO_DATABASE_TABLE
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = HERO_DATABASE_TABLE)
data class Hero(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val image: String,
    val about: String
)