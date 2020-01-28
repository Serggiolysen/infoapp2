package com.lysenko.data.remote.helpers.models

import com.google.gson.annotations.SerializedName

data class Json4Kotlin_Base(

        @SerializedName("account_id") val account_id: Int,
        @SerializedName("steamid") val steamid: String,
        @SerializedName("avatar") val avatar: String,
        @SerializedName("avatarmedium") val avatarmedium: String,
        @SerializedName("avatarfull") val avatarfull: String,
        @SerializedName("profileurl") val profileurl: String,
        @SerializedName("personaname") val personaname: String,
        @SerializedName("last_login") val last_login: String,
        @SerializedName("full_history_time") val full_history_time: String,
        @SerializedName("cheese") val cheese: Int,
        @SerializedName("fh_unavailable") val fh_unavailable: Boolean,
        @SerializedName("loccountrycode") val loccountrycode: String,
        @SerializedName("name") val name: String,
        @SerializedName("country_code") val country_code: String,
        @SerializedName("fantasy_role") val fantasy_role: Int,
        @SerializedName("team_id") val team_id: Int,
        @SerializedName("team_name") val team_name: String,
        @SerializedName("team_tag") val team_tag: String,
        @SerializedName("is_locked") val is_locked: Boolean,
        @SerializedName("is_pro") val is_pro: Boolean,
        @SerializedName("locked_until") val locked_until: Int
)