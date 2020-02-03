package com.lysenko.data.remote.services

import com.lysenko.data.remote.helpers.models.HeroStatApi
import com.lysenko.data.remote.helpers.models.PlayersApi
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiService {

    @GET("./heroStats")
    fun getHeroesStats(): Deferred<List<HeroStatApi>>


    @GET("./proPlayers")
    fun getPlayers(): Deferred<List<PlayersApi>>
}