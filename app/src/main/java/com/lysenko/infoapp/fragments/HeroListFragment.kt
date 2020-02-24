package com.lysenko.infoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lysenko.infoapp.R
import com.lysenko.infoapp.adapters.HeroAdapter
import com.lysenko.domain.models.Hero
import com.lysenko.infoapp.adapters.HeroClickHandler
import com.lysenko.infoapp.di.App
import com.lysenko.infoapp.helpers.Keys
import com.lysenko.infoapp.presenters.HeroListPresenter
import com.lysenko.infoapp.views.HeroListView
import kotlinx.android.synthetic.main.fragment_heroes_list.*

class HeroListFragment: Fragment(), HeroListView{

    lateinit var heroListPresenter: HeroListPresenter
    private lateinit var mAdapter: HeroAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_heroes_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        heroListPresenter = HeroListPresenter(heroListView = this, roomAppDatabase = App.roomDataBase,
                totalAppStartsCount = App.totalCount, domainComponent = App.domainComponent)
        heroListPresenter.fetchPlayers()
        setupAdapter()
    }

    private fun setupAdapter(){
        mAdapter = HeroAdapter()
        recyclerPlayersList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerPlayersList.adapter = mAdapter
        mAdapter.attachClickHandler(object :HeroClickHandler{
            override fun onItemClick(item: Hero) {
                val bundle = Bundle()
                bundle.putParcelable(Keys.Hero.title, item)
                recyclerPlayersList.findNavController().navigate(R.id.heroDetailsFragment, bundle)
            }
        })
    }

    override fun showHeroes(listWithHeroes: List<Hero>) {
        recyclerPlayersList.visibility = View.VISIBLE
        loadingMessage.visibility = View.GONE

        mAdapter.setData(listWithHeroes)
    }

    override fun showLoading() {
        recyclerPlayersList.visibility = View.GONE
        loadingMessage.visibility = View.VISIBLE
    }
}