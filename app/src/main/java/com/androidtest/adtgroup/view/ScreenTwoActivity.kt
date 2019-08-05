package com.androidtest.adtgroup.view

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.androidtest.adtgroup.R
import com.androidtest.adtgroup.databinding.ScreenTwoBinding

class ScreenTwoActivity : AppCompatActivity() {
    private var mBinding: ScreenTwoBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.screen_two)
        var extras = intent.getStringExtra("url")
        mBinding!!.imgUrl= extras
    }
}
