package com.example.gstktor.data.repository

import com.example.gstktor.data.local.GwmDatabase
import com.example.gstktor.domain.model.Hero
import com.example.gstktor.domain.repository.LocalDataSource

class LocalDataSourceImpl(gwmDatabase: GwmDatabase) : LocalDataSource {

    private val heroDao = gwmDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero =
        heroDao.getSelectedHero(heroId = heroId)
}