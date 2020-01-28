package com.lysenko.infoapp.views

import com.lysenko.domain.models.Hero
import com.lysenko.domain.models.Player

interface PlayersListView{
    fun showPlayers(listWithPlayers: List<Player>)
    fun showLoading()
}