package com.androidtest.adtgroup.model

import com.google.gson.annotations.SerializedName

class Response {

    @SerializedName("count")
    var count: Int? = null
    @SerializedName("homes")
    var homes: List<Home>? = null
}

