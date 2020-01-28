package com.lysenko.data.remote.helpers.models


data class HeroStatApi(
        val id: Int, val name: String, var icon: String,
        val attack_type: String, var img: String
)