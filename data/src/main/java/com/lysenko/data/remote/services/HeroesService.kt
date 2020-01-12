package com.lysenko.data.remote.services

import com.lysenko.data.remote.helpers.models.HeroApi
import io.reactivex.Observable
import retrofit2.http.GET

interface HeroesService {

    @GET
    fun getHeroes(): List<HeroApi>
}