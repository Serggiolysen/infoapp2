package com.lysenko.infoapp.presenters

import com.lysenko.data.db.RoomAppDatabase
import com.lysenko.data.di.DataComponent
import com.lysenko.domain.di.DomainComponent
import com.lysenko.domain.repositories.implementations.RepositoryImpl
import com.lysenko.infoapp.views.HeroListView
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeroListPresenter(
    val heroListView: HeroListView,
    val roomAppDatabase: RoomAppDatabase, val totalAppStartsCount: Int,
    val domainComponent: DomainComponent
) : IHeroListPresenter {

    private val repositoryImpl = RepositoryImpl(roomAppDatabase, totalAppStartsCount, domainComponent)

    override fun fetchPlayers() {

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