package com.example.gstktor.domain.use_cases.search_heroes

import androidx.paging.PagingData
import com.example.gstktor.data.repository.Repository
import com.example.gstktor.domain.model.Hero
import kotlinx.coroutines.flow.Flow

class SearchHeroesUseCase(
    private val repository: Repository
) {
    operator fun invoke(query: String): Flow<PagingData<Hero>> =
        repository.searchHeroes(query = query)
}