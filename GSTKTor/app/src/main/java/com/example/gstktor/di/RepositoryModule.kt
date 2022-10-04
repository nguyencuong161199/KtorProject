package com.example.gstktor.di

import com.example.gstktor.data.repository.Repository
import com.example.gstktor.domain.use_cases.UseCases
import com.example.gstktor.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.example.gstktor.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserCases(repository: Repository): UseCases =
        UseCases(
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository)
        )
}
