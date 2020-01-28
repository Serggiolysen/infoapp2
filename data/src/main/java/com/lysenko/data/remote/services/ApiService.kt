package com.lysenko.data.remote.services

import com.lysenko.data.remote.helpers.models.HeroStatApi
import com.lysenko.data.remote.helpers.models.PlayersApi
import io.reactivex.Observable
import retrofit2.http.GET

interface   ApiService {

    @GET("./heroStats")
    fun getHeroesStats(): Observable<List<HeroStatApi>>


    @GET("./proPlayers")
    fun getPlayers(): Observable<List<PlayersApi>>
}