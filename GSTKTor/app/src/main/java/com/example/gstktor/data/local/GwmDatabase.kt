package com.example.gstktor.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.gstktor.data.local.dao.HeroDao
import com.example.gstktor.data.local.dao.HeroRemoteKeysDao
import com.example.gstktor.domain.model.Hero
import com.example.gstktor.domain.model.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class GwmDatabase : RoomDatabase() {
    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}
