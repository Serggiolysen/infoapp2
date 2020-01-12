package com.lysenko.infoapp.presenters

import com.lysenko.domain.models.Hero
import com.lysenko.domain.repositories.implementations.HeroesRepositoryImpl
import com.lysenko.infoapp.views.HeroListView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class HeroListPresenter(var heroListView: HeroListView):IHeroListPresenter {

    private val heroesRepositoryImpl =  HeroesRepositoryImpl()

    override fun fetchHeroes(){

        heroListView.showLoading()

        heroesRepositoryImpl.fetchHeroes().subscribe(object :Observer<List<Hero>>{
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: List<Hero>) {
                heroListView.showHeroes(t)
            }

            override fun onError(e: Throwable) {

            }

        })

//        GlobalScope.launch(Dispatchers.IO) {
//            try {
//                val heroes = heroesRepositoryImpl.fetchHeroes().await()
//                withContext(Dispatchers.IO){
//                    heroListView.showHeroes(listWithHeroes = heroes)
//                }
//            }catch (e:Exception){
//                e.printStackTrace()
//            }
//        }
    }
}