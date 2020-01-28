package com.lysenko.infoapp.presenters

import android.util.Log
import com.lysenko.data.db.RoomAppDatabase
import com.lysenko.domain.models.Hero
import com.lysenko.domain.repositories.implementations.RepositoryImpl
import com.lysenko.infoapp.views.HeroListView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class HeroListPresenter(var heroListView: HeroListView, roomAppDatabase: RoomAppDatabase,
                        totalAppStartsCount: Int)
    : IHeroListPresenter {

    private val heroesRepositoryImpl = RepositoryImpl(roomAppDatabase, totalAppStartsCount)

    override fun fetchHeroes() {

        heroListView.showLoading()

        heroesRepositoryImpl.fetchHeroes().subscribe(object : Observer<List<Hero>> {
            override fun onComplete() {}
            override fun onSubscribe(d: Disposable) {}
            override fun onNext(t: List<Hero>) {
                heroListView.showHeroes(t)
                Log.e("AAAA list Hero ---", t.size.toString())
            }

            override fun onError(e: Throwable) {
                Log.e("AAAA error Hero---", e.message)
            }
        })
    }
}