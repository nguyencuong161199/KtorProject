package com.example.gstktor.domain.use_cases.get_selected_hero

import com.example.gstktor.data.repository.Repository
import com.example.gstktor.domain.model.Hero

class GetSelectedHeroUseCase(
    private val repository: Repository
) {
    suspend operator fun invoke(heroId: Int): Hero =
        repository.getSelectedHero(heroId = heroId)
}