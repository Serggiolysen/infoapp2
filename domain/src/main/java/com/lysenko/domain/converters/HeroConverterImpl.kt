package com.lysenko.domain.converters

import com.lysenko.data.db.model.HeroEntity
import com.lysenko.data.remote.helpers.models.HeroStatApi
import com.lysenko.domain.models.Hero

object HeroConverterImpl {

    fun convertApiToUI(list: List<HeroStatApi>): List<Hero> {
        val tmpArrayList = ArrayList<Hero>()
        for (it in list) {
            tmpArrayList.add(
                    Hero(
                            id = it.id,
                            title = it.name.replace("npc_dota_hero_", ""),
                            icon = it.icon,
                            attackType = if (it.attack_type == "Melee") {
                                0
                            } else {
                                1
                            },
                            img = it.img)
            )
        }
        return tmpArrayList
    }

    fun convertApiToDB(list: List<HeroStatApi>): List<HeroEntity> {
        val tmpArrayList = ArrayList<HeroEntity>()
        for (it in list) {
            tmpArrayList.add(
                    HeroEntity(id = it.id,
                            displayName = it.name.replace("npc_dota_hero_", ""),
                            avatar = it.icon,
                            attack_type = if (it.attack_type == "Melee") {
                                0
                            } else {
                                1
                            },
                            image = it.img
                    )
            )
        }
        return tmpArrayList
    }

    fun convertDBtoUI(list: List<HeroEntity>): List<Hero> {
        val tmpArrayList = ArrayList<Hero>()
        for (it in list) {
            tmpArrayList.add(
                    Hero(id = it.id,
                            title = it.displayName,
                            icon = it.avatar,
                            attackType = it.attack_type,
                            img = it.image)
            )
        }
        return tmpArrayList

    }

}