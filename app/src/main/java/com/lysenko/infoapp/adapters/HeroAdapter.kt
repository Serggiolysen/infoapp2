package com.lysenko.infoapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lysenko.infoapp.R
import com.lysenko.domain.models.Hero
import java.util.*

interface HeroClickHandler {
    fun onItemClick(item: Hero)
}

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    private val mHeroList: MutableList<Hero> = LinkedList()
    private var heroClickHandler: HeroClickHandler? = null

    fun setData(newHeroes: List<Hero>) {
        mHeroList.clear()
        mHeroList.addAll(newHeroes)
        notifyDataSetChanged()
    }

    fun attachClickHandler(heroClickHandler: HeroClickHandler) {
        this.heroClickHandler = heroClickHandler
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
                itemView = LayoutInflater.from(parent.context).inflate(
                        R.layout.cell_hero,
                        parent,
                        false
                ), heroClickHandler = heroClickHandler
        )

    }

    override fun getItemCount(): Int {
        return mHeroList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(model = mHeroList[position])
    }

    class ViewHolder(itemView: View, private val heroClickHandler: HeroClickHandler?) : RecyclerView.ViewHolder(itemView) {
        private val txtTitle: TextView = itemView.findViewById(R.id.txtHeroTitle)
        private val txtAttackType: TextView = itemView.findViewById(R.id.txtHeroAttackType)
        private val imgAvatar: ImageView = itemView.findViewById(R.id.imageAvatar)
        private val cellArea:LinearLayout = itemView.findViewById(R.id.cell_area)

        fun bind(model: Hero) {
            imgAvatar.setOnClickListener {
                heroClickHandler?.onItemClick(item = model)
            }
            cellArea.setOnClickListener {
                heroClickHandler?.onItemClick(item = model)
            }

            txtTitle.text = model.title

            if (model.attackType == 0) {
                txtAttackType.text = itemView.context.getString(R.string.attack_type_melee)
            } else {
                txtAttackType.text = itemView.context.getString(R.string.attack_type_ranged)
            }

            Glide.with(itemView.context)
                    .load("https://api.opendota.com${model.icon}")
                    .fitCenter()
                    .into(imgAvatar)

        }
    }

}