package com.example.gstktor.data.remote

import com.example.gstktor.domain.model.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GwmApi {
    @GET("/gwm/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1
    ): ApiResponse

    @GET("/gwm/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String
    ): ApiResponse
}