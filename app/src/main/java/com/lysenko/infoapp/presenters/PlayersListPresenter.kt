package com.lysenko.infoapp.presenters

import com.lysenko.data.db.RoomAppDatabase
import com.lysenko.domain.di.DomainComponent
import com.lysenko.domain.repositories.implementations.RepositoryImpl
import com.lysenko.infoapp.views.PlayersListView
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch

class PlayersListPresenter(
    var playersListView: PlayersListView, val roomAppDatabase: RoomAppDatabase,
    val totalAppStartsCount: Int, domainComponent: DomainComponent
) : IHeroListPresenter {

    private val repositoryImpl =
        RepositoryImpl(roomAppDatabase, totalAppStartsCount, domainComponent)

    override fun fetchPlayers() {

        playersListView.showLoading()

        CoroutineScope(IO).launch {
            val listPlayers = repositoryImpl.fetchPlayers().await()
            if (listPlayers.isEmpty()) {
                launch(Main) {
                    throw CancellationException()
                }
            } else {
                launch(Main) {
                    playersListView.showPlayers(listPlayers)
                }
            }
        }
    }
}