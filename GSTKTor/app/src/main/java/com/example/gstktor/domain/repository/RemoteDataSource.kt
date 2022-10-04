package com.example.gstktor.domain.repository

import androidx.paging.PagingData
import com.example.gstktor.domain.model.Hero
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getAllHeroes(): Flow<PagingData<Hero>>
}