package com.example.gstktor.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.example.gstktor.data.local.GwmDatabase
import com.example.gstktor.data.repository.LocalDataSourceImpl
import com.example.gstktor.domain.repository.LocalDataSource
import com.example.gstktor.util.Constants.GWM_DATABASE
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): GwmDatabase =
        Room.databaseBuilder(
            context,
            GwmDatabase::class.java,
            GWM_DATABASE
        ).build()

    @Provides
    @Singleton
    fun provideLocalDataSource(
        database: GwmDatabase
    ): LocalDataSource =
        LocalDataSourceImpl(gwmDatabase = database)

}