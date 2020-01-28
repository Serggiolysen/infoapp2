package com.lysenko.infoapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lysenko.domain.models.Player
import com.lysenko.infoapp.R
import java.util.*

interface PlayerClickHandler {
    fun onItemClick(item: Player)
}

class PlayerAdapter : RecyclerView.Adapter<PlayerAdapter.ViewHolder>() {

    private val playersList: MutableList<Player> = LinkedList()
    private var playerClickHandler: PlayerClickHandler? = null

    fun setData(newPlayers: List<Player>) {
        playersList.clear()
        playersList.addAll(newPlayers)
        notifyDataSetChanged()
    }

    fun attachClickHandler(playerClickHandler: PlayerClickHandler?) {
        this.playerClickHandler = playerClickHandler
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                itemView = LayoutInflater.from(parent.context).inflate(
                        R.layout.cell_player,
                        parent,
                        false
                ), playerClickHandler = playerClickHandler
        )

    }

    override fun getItemCount(): Int {
        return playersList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(model = playersList[position])
    }

    class ViewHolder(itemView: View, private val playerClickHandler: PlayerClickHandler?) : RecyclerView.ViewHolder(itemView) {
        private val txtName: TextView = itemView.findViewById(R.id.txtPlayerName)
        private val txtIsPro: TextView = itemView.findViewById(R.id.txtPlayerIsPro)
        private val imgAvatarPlayer: ImageView = itemView.findViewById(R.id.imageAvatarPlayer)
        private val cellAreaPlayer:LinearLayout = itemView.findViewById(R.id.cell_area_player)

        fun bind(model: Player) {
            imgAvatarPlayer.setOnClickListener {
                playerClickHandler?.onItemClick(item = model)
            }
            cellAreaPlayer.setOnClickListener {
                playerClickHandler?.onItemClick(item = model)
            }

            txtName.text = model.name

            if (model.is_pro == true) {
                txtIsPro.text = itemView.context.getString(R.string.pro)
            } else {
                txtIsPro.text = itemView.context.getString(R.string.not_pro)
            }

            Glide.with(itemView.context)
                    .load(model.avatar)
                    .fitCenter()
                    .into(imgAvatarPlayer)

        }
    }

}