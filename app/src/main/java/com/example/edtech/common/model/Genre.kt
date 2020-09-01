package com.example.edtech.common.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Genre (

    val id : Int,
    val name : String

) : Parcelable

