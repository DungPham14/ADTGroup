package com.androidtest.adtgroup.view

import android.support.v7.widget.RecyclerView
import android.view.View
import com.androidtest.adtgroup.databinding.ListItemLeftBinding
import com.androidtest.adtgroup.databinding.ListItemRightBinding

class ViewHolder : RecyclerView.ViewHolder {
    lateinit var mItemLeft: ListItemLeftBinding
    lateinit var mItemRight: ListItemRightBinding

    constructor(itemView: ListItemLeftBinding) : super(itemView.root) {
        this.mItemLeft = itemView
    }

    constructor(itemView: ListItemRightBinding) : super(itemView.root) {
        this.mItemRight = itemView
    }
}
