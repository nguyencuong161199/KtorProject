package com.example.gstktor.domain.repository

import com.example.gstktor.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}