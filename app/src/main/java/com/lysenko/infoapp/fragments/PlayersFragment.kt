package com.lysenko.infoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lysenko.domain.models.Player
import com.lysenko.infoapp.R
import com.lysenko.infoapp.adapters.PlayerAdapter
import com.lysenko.infoapp.adapters.PlayerClickHandler
import com.lysenko.infoapp.di.App
import com.lysenko.infoapp.helpers.Keys
import com.lysenko.infoapp.presenters.PlayersListPresenter
import com.lysenko.infoapp.views.PlayersListView
import kotlinx.android.synthetic.main.fragment_players.*

class PlayersFragment :Fragment(), PlayersListView{

    lateinit var playersListPresenter: PlayersListPresenter
    private lateinit var mAdapter: PlayerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_players, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playersListPresenter = PlayersListPresenter(playersListView = this, roomAppDatabase = App.roomDataBase,
                totalAppStartsCount = App.totalCount)
        playersListPresenter.fetchHeroes()
        setupAdapter()
    }

    private fun setupAdapter(){
        mAdapter = PlayerAdapter()
        recyclerPlayersList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,
                false)
        recyclerPlayersList.adapter = mAdapter
        mAdapter.attachClickHandler(object :PlayerClickHandler{
            override fun onItemClick(item: Player) {
                val bundle = Bundle()
                bundle.putParcelable(Keys.Player.title, item)
                recyclerPlayersList.findNavController().navigate(R.id.playerDetailsFragment, bundle)
            }
        })
    }

    override fun showPlayers(listWithPlayers: List<Player>) {
        recyclerPlayersList.visibility = View.VISIBLE
        loadingMessage.visibility = View.GONE

        mAdapter.setData(listWithPlayers)
    }

    override fun showLoading() {
        recyclerPlayersList.visibility = View.GONE
        loadingMessage.visibility = View.VISIBLE
    }
}