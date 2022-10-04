package com.example.gstktor.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.example.gstktor.data.repository.DataStoreOperationsImpl
import com.example.gstktor.data.repository.Repository
import com.example.gstktor.domain.repository.DataStoreOperations
import com.example.gstktor.domain.use_cases.UseCases
import com.example.gstktor.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.example.gstktor.domain.use_cases.get_selected_hero.GetSelectedHeroUseCase
import com.example.gstktor.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.example.gstktor.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.example.gstktor.domain.use_cases.search_heroes.SearchHeroesUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations = DataStoreOperationsImpl(context = context)

    @Provides
    @Singleton
    fun provideUserCases(repository: Repository): UseCases =
        UseCases(
            saveOnBoardingUserCase = SaveOnBoardingUseCase(repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository),
            getSelectedHeroUseCase = GetSelectedHeroUseCase(repository)
        )
}