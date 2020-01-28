package com.lysenko.data.remote.services

import com.lysenko.data.remote.helpers.models.HeroStatApi
import io.reactivex.Observable
import retrofit2.http.GET

interface   HeroesService {

    @GET("./heroStats")
    fun getHeroesStats(): Observable<List<HeroStatApi>>
}