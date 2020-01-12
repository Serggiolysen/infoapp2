package com.lysenko.infoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.lysenko.infoapp.R
import com.lysenko.infoapp.adapters.HeroAdapter
import com.lysenko.domain.models.Hero
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
        heroListPresenter = HeroListPresenter(this)
        heroListPresenter.fetchHeroes()//???? first or second???
        setupAdapter()
    }

    private fun setupAdapter(){
        mAdapter = HeroAdapter()
        recyclerHeroList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerHeroList.adapter = mAdapter
    }

    override fun showHeroes(listWithHeroes: List<Hero>) {
        recyclerHeroList.visibility = View.VISIBLE
        loadingMessage.visibility = View.GONE

        mAdapter.setData(listWithHeroes)
    }

    override fun showLoading() {
        recyclerHeroList.visibility = View.GONE
        loadingMessage.visibility = View.VISIBLE
    }
}