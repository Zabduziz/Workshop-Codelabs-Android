package com.example.karakater

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Karakters(
    var name : String = "",
    var ability : String = "",
    var live : String = "",
    var detail : String = "",
    var photo : Int = 0,
) : Parcelable
