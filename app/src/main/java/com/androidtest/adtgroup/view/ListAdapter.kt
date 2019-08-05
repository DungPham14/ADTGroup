package com.androidtest.adtgroup.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout

import com.androidtest.adtgroup.R
import com.androidtest.adtgroup.databinding.ListItemLeftBinding
import com.androidtest.adtgroup.databinding.ListItemRightBinding
import com.androidtest.adtgroup.model.Home

class ListAdapter(context: Context, private val mHomeList: List<Home>?) : RecyclerView.Adapter<ViewHolder>() {
    private val mInflater: LayoutInflater
    private var mListener: ItemListener? = null

    init {
        this.mInflater = LayoutInflater.from(context)
    }

    fun setListener(mListener: ItemListener) {
        this.mListener = mListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val li = LayoutInflater.from(viewGroup.context)
        val mBinding: ViewDataBinding
        return when (i) {
            ITEM_LEFT -> {
                mBinding = DataBindingUtil.inflate(li, R.layout.list_item_left, viewGroup, false)
                return ViewHolder(mBinding as ListItemLeftBinding)
            }
            ITEM_RIGHT -> {
                mBinding = DataBindingUtil.inflate(li, R.layout.list_item_right, viewGroup, false)
                return ViewHolder(mBinding as ListItemRightBinding)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val lp = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT)
        viewHolder.itemView.layoutParams = lp
        val home = mHomeList!![i]
        when (viewHolder.itemViewType) {
            ITEM_LEFT -> {
                val itemLeft = viewHolder.mItemLeft
                itemLeft.image.scaleType = ImageView.ScaleType.MATRIX
                itemLeft.res = home
                itemLeft.imgUrl = URL + home.media!!.url!!
                itemLeft.onclick = mListener
            }
            ITEM_RIGHT -> {
                val itemRight = viewHolder.mItemRight
                itemRight.imageView.scaleType = ImageView.ScaleType.CENTER_CROP
                itemRight.ref = home
                itemRight.imgUrl = URL + home.media!!.url!!
                itemRight.onclick = mListener
            }
        }
    }

    override fun getItemCount(): Int {
        return mHomeList?.size ?: 0
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) {
            ITEM_LEFT
        } else {
            ITEM_RIGHT
        }
    }

    companion object {
        private val ITEM_LEFT = 0
        private val ITEM_RIGHT = 2
        private val URL = "http://admin.adtdisplay.vn/"
    }
}
