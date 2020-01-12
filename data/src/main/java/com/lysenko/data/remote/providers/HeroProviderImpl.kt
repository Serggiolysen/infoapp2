package com.lysenko.data.remote.providers

import com.lysenko.data.remote.helpers.RetrofitFactory
import com.lysenko.data.remote.helpers.models.HeroApi
import io.reactivex.Observable

class HeroProviderImpl {

// тут и hero и аватарку соединяем

    fun getHeroesList(): List<HeroApi> {
        return RetrofitFactory().getHeroesService().getHeroes()
    }
}