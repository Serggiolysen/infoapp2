package com.lysenko.domain.converters

import com.lysenko.data.db.model.HeroEntity
import com.lysenko.data.remote.helpers.models.HeroStatApi
import com.lysenko.domain.models.Hero

object HeroConverterImpl {

    fun convertApiToUI(heroStatApi: HeroStatApi): Hero {

        return Hero(id = heroStatApi.id,
                title = heroStatApi.name.replace("npc_dota_hero_", ""),
                icon = heroStatApi.icon,
                attackType = if (heroStatApi.attack_type == "Melee") {
                    0
                } else {
                    1
                },
                img = heroStatApi.img)
    }

    fun convertApiToDB(heroStatApi: HeroStatApi): HeroEntity {
        return HeroEntity(id = heroStatApi.id,
                displayName = heroStatApi.name.replace("npc_dota_hero_", ""),
                avatar = heroStatApi.icon,
                attack_type = if (heroStatApi.attack_type == "Melee") {
                    0
                } else {
                    1
                },
                image = heroStatApi.img
        )
    }

    fun convertDBtoUI(heroEntity: HeroEntity): Hero {
        return Hero(id = heroEntity.id,
                title = heroEntity.displayName,
                icon = heroEntity.avatar,
                attackType = heroEntity.attack_type,
                img = heroEntity.image)
    }
}