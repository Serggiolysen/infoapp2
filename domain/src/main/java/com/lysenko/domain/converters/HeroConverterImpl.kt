package com.lysenko.domain.converters

import com.lysenko.data.remote.helpers.models.HeroApi
import com.lysenko.domain.models.Hero

class HeroConverterImpl {

    fun fromIpToUI(model: List<HeroApi>): List<Hero> {
        val tmpData = ArrayList<Hero>()
        model.forEach {
            tmpData.add(
                Hero(
                    id = it.id, title = it.name.replace("npc_dota_hero_", ""),
                    attackType = if (it.attack_type == "Melee") {
                        0
                    } else {
                        1
                    }, icon = ""
                )
            )
        }

        return tmpData
    }

//    fun fromIpToUI(model: HeroApi): Hero {
//
//        return Hero(
//            id = model.id, title = model.name.replace("npc_dota_hero_", ""),
//            attackType = if (model.attack_type == "Melee") {
//                0
//            } else {
//                1
//            }, icon = ""
//        )
//    }
}