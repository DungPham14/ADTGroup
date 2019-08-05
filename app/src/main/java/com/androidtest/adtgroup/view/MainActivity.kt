package com.androidtest.adtgroup.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import com.androidtest.adtgroup.R
import com.androidtest.adtgroup.databinding.ActivityMainBinding
import com.androidtest.adtgroup.model.Home
import com.androidtest.adtgroup.viewModel.MainViewModel

class MainActivity : AppCompatActivity(), ItemListener {
    private var mainBinding: ActivityMainBinding? = null
    private var mAdapter: ListAdapter? = null
    private val articleArrayList = ArrayList<Home>()
    private var mViewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initData()
        initView()
    }

    private fun initData() {
        mViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java!!)
        var newsArticles: List<Home>? = null
        mViewModel!!.init()
        mViewModel!!.getmLiveData()!!.observe(this, Observer { res ->
            if (res != null) {
                newsArticles = res.homes
            }
            this.articleArrayList.addAll(newsArticles!!)
            mAdapter!!.notifyDataSetChanged()
        })
        mAdapter = ListAdapter(this, articleArrayList)
    }

    private fun initView() {
        val mLayoutManager = LinearLayoutManager(this)
        mainBinding!!.recycleView.layoutManager = mLayoutManager
        mainBinding!!.recycleView.adapter = mAdapter
        mAdapter!!.setListener(this@MainActivity)
    }

    override fun clickItem(h: Home) {
        val i = Intent(this, ScreenTwoActivity::class.java)
        i.putExtra(EXTRAS_URL, URL + h.media!!.url!!)
        startActivity(i)
    }

    companion object {
        private val URL = "http://admin.adtdisplay.vn/"
        var EXTRAS_URL = "url"
    }
}

