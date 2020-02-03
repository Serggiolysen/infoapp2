package com.lysenko.domain.models

import android.os.Parcel
import android.os.Parcelable

data class Player(
        val account_id: Int,
        val avatar: String?,
        val avatarfull: String?,
        val personaname: String?,
        val name: String?,
        val country_code: String?,
//        val team_name: String?,
        val is_pro: Boolean
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(account_id)
        parcel.writeString(avatar)
        parcel.writeString(avatarfull)
        parcel.writeString(personaname)
        parcel.writeString(name)
        parcel.writeString(country_code)
        parcel.writeByte(if (is_pro) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Player> {
        override fun createFromParcel(parcel: Parcel): Player {
            return Player(parcel)
        }

        override fun newArray(size: Int): Array<Player?> {
            return arrayOfNulls(size)
        }
    }
}