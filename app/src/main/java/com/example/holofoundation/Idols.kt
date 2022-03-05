package com.example.holofoundation

import android.os.Parcel
import android.os.Parcelable

data class Idols(
    val name: String?,
    val bio: String?,
    val image: Int,
    val details : String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(bio)
        parcel.writeInt(image)
        parcel.writeString(details)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Idols> {
        override fun createFromParcel(parcel: Parcel): Idols {
            return Idols(parcel)
        }

        override fun newArray(size: Int): Array<Idols?> {
            return arrayOfNulls(size)
        }
    }
}