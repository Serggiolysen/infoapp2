package com.lysenko.infoapp.presenters

import android.util.Log
import com.lysenko.data.db.RoomAppDatabase
import com.lysenko.domain.models.Hero
import com.lysenko.domain.models.Player
import com.lysenko.domain.repositories.implementations.RepositoryImpl
import com.lysenko.infoapp.views.PlayersListView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

class PlayersListPresenter(var playersListView: PlayersListView, roomAppDatabase: RoomAppDatabase,
                           totalAppStartsCount: Int)
    : IHeroListPresenter {

    private val repositoryImpl = RepositoryImpl(roomAppDatabase, totalAppStartsCount)

    override fun fetchHeroes() {

        playersListView.showLoading()

        repositoryImpl.fetchPlayers().subscribe(object : Observer<List<Player>> {
            override fun onComplete() {}
            override fun onSubscribe(d: Disposable) {}
            override fun onNext(t: List<Player>) {
                playersListView.showPlayers(t)
                Log.e("AAAA list Players--", t.size.toString())
            }

            override fun onError(e: Throwable) {
                Log.e("AAAA error Players---", e.message)
            }
        })
    }
}