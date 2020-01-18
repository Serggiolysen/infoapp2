package com.lysenko.data.remote.providers

import com.lysenko.data.remote.helpers.RetrofitFactory
import com.lysenko.data.remote.helpers.models.HeroStatApi
import io.reactivex.Observable

object HeroProviderImpl {

    fun getHeroStats(): Observable<List<HeroStatApi>> {
        return RetrofitFactory().getHeroesService().getHeroesStats()
    }

}