package com.lysenko.data.remote.helpers.models

import kotlinx.serialization.ImplicitReflectionSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.UnstableDefault
import kotlinx.serialization.json.Json

@Serializable
data class PlayersApi(

    val account_id: Int,
    val steamid: String,
    val avatar: String,
    val avatarmedium: String,
    val avatarfull: String,
    val profileurl: String,
    val personaname: String,
//    val last_login: String,
//    val full_history_time: String,
    val cheese: Int,
//    val fh_unavailable: Boolean,
//    val loccountrycode: String,
    val name: String,
    val country_code: String,
    val fantasy_role: Int,
    val team_id: Int,
//    val team_name: String,
//    val team_tag: String,
    val is_locked: Boolean,
    val is_pro: Boolean
//    val locked_until: Int
) {
    companion object {
        @ImplicitReflectionSerializer
        @UnstableDefault
        fun toObject(stringValue: String): PlayersApi {
            return Json.nonstrict.parse(serializer(), stringValue)
        }
    }
}

// Extension for serialization
@UnstableDefault
fun PlayersApi.toJson(): String {
    return Json.stringify(PlayersApi.serializer(), this)

}