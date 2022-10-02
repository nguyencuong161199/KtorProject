package com.example.gstktor.data.repository

import com.example.gstktor.data.local.BorutoDatabase
import com.example.gstktor.domain.model.Hero
import com.example.gstktor.domain.repository.LocalDataSource

class LocalDataSourceImpl(borutoDatabase: BorutoDatabase) : LocalDataSource {

    private val heroDao = borutoDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero =
        heroDao.getSelectedHero(heroId = heroId)
}