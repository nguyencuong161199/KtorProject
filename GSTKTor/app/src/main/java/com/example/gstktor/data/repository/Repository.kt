package com.example.gstktor.data.repository

import androidx.paging.PagingData
import com.example.gstktor.domain.model.Hero
import com.example.gstktor.domain.repository.LocalDataSource
import com.example.gstktor.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> =
        remote.getAllHeroes()

    suspend fun getSelectedHero(heroId: Int): Hero =
        local.getSelectedHero(heroId = heroId)

}
