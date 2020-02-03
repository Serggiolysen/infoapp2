package com.lysenko.data.remote.helpers.models

import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json

@Serializable
data class HeroStatApi(
    val id: Int, val name: String, var icon: String,
    val attack_type: String, var img: String
) {
    companion object {
        @ImplicitReflectionSerializer
        @UnstableDefault
        fun toObject(stringValue: String): HeroStatApi {
            return Json.nonstrict.parse(serializer(), stringValue)
        }
    }
}

// Extension for serialization
@UnstableDefault
fun HeroStatApi.toJson(): String {
    return Json.stringify(HeroStatApi.serializer(), this)

}