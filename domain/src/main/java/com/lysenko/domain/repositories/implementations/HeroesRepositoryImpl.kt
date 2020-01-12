package com.lysenko.domain.repositories.implementations

import com.lysenko.data.remote.helpers.models.HeroApi
import com.lysenko.data.remote.providers.HeroProviderImpl
import com.lysenko.domain.converters.HeroConverterImpl
import com.lysenko.domain.models.Hero
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class HeroesRepositoryImpl() : IHeroesRepository {

    fun fromIpToUI(model: List<HeroApi>): List<Hero> {
        val tmpData = ArrayList<Hero>()
        model.forEach {
            tmpData.add(
                Hero(
                    id = it.id, title = it.name.replace("npc_dota_hero_", ""),
                    attackType = if (it.attack_type == "Melee") {
                        0
                    } else {
                        1
                    }, icon = ""
                )
            )
        }

        return tmpData
    }

    private val heroProviderImpl = HeroProviderImpl()

    override fun fetchHeroes(): Observable<List<Hero>> {

        val heroApiList = heroProviderImpl.getHeroesList()

        val tmpData = ArrayList<Hero>()

        heroApiList.forEach {
            tmpData.add(
                Hero(
                    id = it.id, title = it.name.replace("npc_dota_hero_", ""),
                    attackType = if (it.attack_type == "Melee") {
                        0
                    } else {
                        1
                    }, icon = ""
                )
            )
        }

        return Observable
            .create { emitter: ObservableEmitter<List<Hero>> ->
                emitter.onNext(tmpData)
            }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())

//        val mockdata = ArrayList<Hero>()
//        mockdata.add(Hero(0, "One", "", 0))
//        mockdata.add(Hero(1, "Two", "", 1))
//        mockdata.add(Hero(2, "Three", "", 1))
//
//        return Observable
//            .create { emitter: ObservableEmitter<List<Hero>> ->
//                emitter.onNext(mockdata)
//            }
//            .subscribeOn(Schedulers.computation())
//            .delay(3, TimeUnit.SECONDS)
//            .observeOn(AndroidSchedulers.mainThread())
    }

    //    fun fetchHeroes(): Deferred<List<Hero>> {
//
//        Thread.sleep(3000)
//
//        val mockdata = ArrayList<Hero>()
//        mockdata.add(Hero(0, "One", "", 0))
//        mockdata.add(Hero(1, "Two", "", 1))
//        mockdata.add(Hero(2, "Three", "", 1))
//
//        return GlobalScope.async { mockdata }
//    }
}
