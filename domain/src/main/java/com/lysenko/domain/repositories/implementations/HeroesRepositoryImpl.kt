package com.lysenko.domain.repositories.implementations

import com.lysenko.data.remote.helpers.models.HeroApi
import com.lysenko.data.remote.helpers.models.HeroStatApi
import com.lysenko.data.remote.providers.HeroProviderImpl
import com.lysenko.domain.converters.HeroConverterImpl
import com.lysenko.domain.models.Hero
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class HeroesRepositoryImpl : IHeroesRepository {

    private lateinit var listHeroApi: List<Hero>
    private lateinit var listHeroStatsApi: List<Hero>


    override fun fetchHeroes(): Observable<List<Hero>> {
        return HeroProviderImpl.getHeroStats().map {
            HeroConverterImpl.convertHeroesStatsApiToHeroes(it)
        }!!.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())

    }



}