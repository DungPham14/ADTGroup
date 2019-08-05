package com.androidtest.adtgroup.model

import com.google.gson.annotations.SerializedName

class Media {

    @SerializedName("created_at")
    var createdAt: String? = null

    @SerializedName("updated_at")
    var updatedAt: String? = null

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("url")
    var url: String? = null

    @SerializedName("type ")
    var type: Int? = null

    @SerializedName("marketId ")
    var marketId: Int? = null
}
