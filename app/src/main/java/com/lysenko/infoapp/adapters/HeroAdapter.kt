package com.lysenko.infoapp.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lysenko.infoapp.R
import com.lysenko.domain.models.Hero
import java.util.*

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {

    private val mHeroList: MutableList<Hero> = LinkedList()

    fun setData(newHeroes: List<Hero>) {
        mHeroList.clear()
        mHeroList.addAll(newHeroes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            itemView = LayoutInflater.from(parent.context).inflate(
                R.layout.cell_hero,
                parent,
                false
            )
        )

    }

    override fun getItemCount(): Int {
        return mHeroList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(model = mHeroList[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTitle:TextView = itemView.findViewById(R.id.txtHeroTitle)
        private val txtAttackType:TextView = itemView.findViewById(R.id.txtHeroAttackType)
        private val imgAvatar: ImageView = itemView.findViewById(R.id.imageAvatar)

        fun bind(model: Hero) {
            txtTitle.text = model.title

            if (model.attackType == 0){
                txtAttackType.text = itemView.context.getString(R.string.attack_type_melee)
            }else{
                txtAttackType.text = itemView.context.getString(R.string.attack_type_ranged)
            }

            Glide.with(itemView.context)
                .load("https://api.opendota.com/apps/dota2/images/heroes/antimage_full.png?")
                .fitCenter()
                .into(imgAvatar)

            Log.d("AAAAA", model.icon)
        }
    }

}