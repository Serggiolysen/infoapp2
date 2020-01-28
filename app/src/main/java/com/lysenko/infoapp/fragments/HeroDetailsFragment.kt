package com.lysenko.infoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.lysenko.domain.models.Hero
import com.lysenko.infoapp.R
import com.lysenko.infoapp.helpers.Keys
import kotlinx.android.synthetic.main.fragment_hero_details.*

class HeroDetailsFragment : Fragment() {

    private var heroArgs: Hero? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        heroArgs = arguments?.getParcelable(Keys.Hero.title)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hero_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureView()
    }

    private fun configureView() {
        heroArgs?.let { hero ->
            heroName.text = hero.title

            Glide.with(heroAvatar)
                    .load("https://api.opendota.com${hero.img}")
                    .into(heroAvatar)
        }
    }
}