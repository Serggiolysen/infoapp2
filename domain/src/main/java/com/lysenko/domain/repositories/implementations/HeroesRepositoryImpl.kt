package com.lysenko.domain.repositories.implementations

import com.lysenko.data.db.RoomAppDatabase
import com.lysenko.data.remote.providers.HeroProviderImpl
import com.lysenko.domain.converters.HeroConverterImpl
import com.lysenko.domain.models.Hero
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HeroesRepositoryImpl(private var roomAppDatabase: RoomAppDatabase,
                           private var totalAppStartsCount: Int)
    : IHeroesRepository {

    override fun fetchHeroes(): Observable<List<Hero>> {

        val observsbleListHeroFromNet = HeroProviderImpl.getHeroStats().map {
            roomAppDatabase.heroDao().insertHero(HeroConverterImpl.convertApiToDB(it))
            HeroConverterImpl.convertApiToUI(it)
        }.subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())

        val observsbleListHeroFromDB = roomAppDatabase.heroDao().fetchHeroes().map {
            HeroConverterImpl.convertDBtoUI(it)
        }.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        return if ((totalAppStartsCount%20) == 0){
            observsbleListHeroFromNet
        }else observsbleListHeroFromDB

    }
}
