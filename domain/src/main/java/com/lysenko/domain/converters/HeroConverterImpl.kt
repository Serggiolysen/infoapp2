package com.lysenko.domain.converters

import com.lysenko.data.remote.helpers.models.HeroStatApi
import com.lysenko.domain.models.Hero

object HeroConverterImpl {

    fun convertHeroesStatsApiToHeroes(model2: List<HeroStatApi>): List<Hero> {
        val tmpData2 = ArrayList<Hero>()

        for (it in model2) {
            tmpData2.add(
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
        return tmpData2
    }
}


/*
fun convertLists(model: List<HeroApi>, model2: List<HeroStatApi>): List<Hero> {

val tmpData = ArrayList<Hero>()

for (it in model) {
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

val tmpData2 = ArrayList<Hero>()

for (it in model2) {
tmpData2.add(
Hero(id = 0, title = "", attackType = 0, icon = it.img
)
)
}

for (i in tmpData) {
for (j in tmpData2) {
i.icon = j.icon
}
}
return tmpData
}
*/


