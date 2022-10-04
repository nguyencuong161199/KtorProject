package com.example.gstktor.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.gstktor.data.local.GwmDatabase
import com.example.gstktor.data.paging_source.HeroRemoteMediator
import com.example.gstktor.data.remote.GwmApi
import com.example.gstktor.domain.model.Hero
import com.example.gstktor.domain.repository.RemoteDataSource
import com.example.gstktor.util.Constants.ITEMS_PER_PAGE
import kotlinx.coroutines.flow.Flow

@ExperimentalPagingApi
class RemoteDataSourceImpl(
    private val gwmApi: GwmApi,
    private val gwmDatabase: GwmDatabase
) : RemoteDataSource {

    private val heroDao = gwmDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = ITEMS_PER_PAGE),
            remoteMediator = HeroRemoteMediator(
                gwmApi = gwmApi,
                gwmDatabase = gwmDatabase
            ),
            pagingSourceFactory = pagingSourceFactory
        ).flow
    }
}