package com.example.gstktor.data.repository

import androidx.paging.PagingData
import com.example.gstktor.domain.model.Hero
import com.example.gstktor.domain.repository.DataStoreOperations
import com.example.gstktor.domain.repository.LocalDataSource
import com.example.gstktor.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val local: LocalDataSource,
    private val remote: RemoteDataSource,
    private val dataStore: DataStoreOperations
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> =
        remote.getAllHeroes()

    fun searchHeroes(query: String): Flow<PagingData<Hero>> =
        remote.searchHeroes(query = query)

    suspend fun getSelectedHero(heroId: Int): Hero =
        local.getSelectedHero(heroId = heroId)

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> =
        dataStore.readOnBoardingState()

}