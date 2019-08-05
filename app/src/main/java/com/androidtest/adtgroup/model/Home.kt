package com.androidtest.adtgroup.model

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName

class Home {
    @SerializedName("created_at")
    var createdAt: String? = null

    @SerializedName("updated_at")
    var updatedAt: String? = null

    @SerializedName("id")
    var id: Int? = null

    @SerializedName("orientation")
    var orientation: Int? = null

    @SerializedName("order")
    var order: Int? = null

    @SerializedName("time")
    var time: Int? = null

    @SerializedName("marketId")
    var marketId: Int? = null

    @SerializedName("deviceId")
    var deviceId: Int? = null

    @SerializedName("mediaId")
    var mediaId: Int? = null

    @SerializedName("media")
    var media: Media? = null

    companion object {
        @JvmStatic
        @BindingAdapter("app:profileImage")
        fun loadImage(view: ImageView, home: String) {
            Glide.with(view.context).load(home).into(view)
        }
    }
}
