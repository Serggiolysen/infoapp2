package com.lysenko.infoapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.lysenko.domain.models.Player
import com.lysenko.infoapp.R
import com.lysenko.infoapp.helpers.Keys
import kotlinx.android.synthetic.main.fragment_player_details.*

class PlayerDetailsFragment : Fragment() {

    private var playerArgs: Player? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        playerArgs = arguments?.getParcelable(Keys.Player.title)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configureView()
    }

    private fun configureView() {
        playerArgs?.let { player ->
            playerName.text = player.name
            account_id.text = "Account ID: ${player.account_id.toString()}"

            if (player.country_code!!.length < 1 || player.country_code == null) {
                country_code.text = getString(R.string.no_country_info)
            } else country_code.text = "Country: ${player.country_code}"

            if (player.team_name == null || player.team_name!!.length < 1) {
                getString(R.string.not_consists_in_team)
            } else team_name.text = "Team: ${player.team_name}"

            if (player.is_pro == true) {
                is_pro.text = getString(R.string.pro)
            } else is_pro.text = getString(R.string.not_pro)

            Glide.with(playerAvatar)
                    .load(player.avatarfull)
                    .into(playerAvatar)
        }
    }
}