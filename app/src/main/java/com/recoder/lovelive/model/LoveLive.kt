package com.recoder.lovelive.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class LoveLive (
    var name : String ?= "",
    var isFavorite : Boolean ?= false,
    var thumbnail : Int ?= 0,
    var photo : Int ?= 0,
    var icon : Int ?= 0,
    var cv : String ?= "",
    var year : Int ?= 0,
    var birthday : String ?= "",
    var bloodType : String ?= "",
    var height : Int ?= 0,
    var description : String ?= "",
    var background : String ?= "",
    var personality: String ?= "",
    var video : String ?= "",
    var songName : String ?= "",
    var songFile : String ?= "",
    var references : String ?= ""
) : Parcelable