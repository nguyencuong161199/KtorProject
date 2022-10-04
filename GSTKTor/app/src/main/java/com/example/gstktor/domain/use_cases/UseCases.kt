package com.example.gstktor.domain.use_cases // ktlint-disable package-name

import com.example.gstktor.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.example.gstktor.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase

data class UseCases(
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val getSelectedHeroUseCase: GetSelectedHeroUseCase
)
