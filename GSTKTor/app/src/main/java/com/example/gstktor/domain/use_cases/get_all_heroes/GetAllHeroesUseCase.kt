package com.example.gstktor.domain.use_cases.get_all_heroes

import androidx.paging.PagingData
import com.example.gstktor.data.repository.Repository
import com.example.gstktor.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class GetAllHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(): Flow<PagingData<Hero>> =
        repository.getAllHeroes()
}