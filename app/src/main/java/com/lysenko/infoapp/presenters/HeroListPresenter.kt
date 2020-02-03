package com.lysenko.infoapp.presenters

import com.lysenko.data.db.RoomAppDatabase
import com.lysenko.domain.repositories.implementations.RepositoryImpl
import com.lysenko.infoapp.views.HeroListView
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroListPresenter(var heroListView: HeroListView, roomAppDatabase: RoomAppDatabase,
                        totalAppStartsCount: Int)
    : IHeroListPresenter {

    private val repositoryImpl = RepositoryImpl(roomAppDatabase, totalAppStartsCount)

    override fun fetchHeroes() {

        heroListView.showLoading()

        CoroutineScope(context = Dispatchers.IO).launch {
            val listHeroes = repositoryImpl.fetchHero().await()
            if (listHeroes.isEmpty()) {
                launch(Dispatchers.Main) {
                    throw CancellationException()
                }
            } else {
                launch(Dispatchers.Main) {
                    heroListView.showHeroes(listHeroes)
                }
            }
        }
    }
}