package com.ridhotiyar.usergithub

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Users(
    var name: String,
    var company: String,
    var photo: Int,
    var username: String,
    var location: String,
    var repository: String,
    var followers: String,
    var following: String

) : Parcelable
