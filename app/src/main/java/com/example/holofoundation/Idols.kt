package com.example.holofoundation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Idols(
    val name: String?,
    val bio: String?,
    val image: Int,
    val details : String?
) : Parcelable