package com.androidtest.adtgroup.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.androidtest.adtgroup.model.MainRepository
import com.androidtest.adtgroup.model.Response

class MainViewModel : ViewModel() {
    private var mLiveData: MutableLiveData<Response>? = null
    private var mMainRepository: MainRepository? = null

    fun init() {
        if (mLiveData != null) {
            return
        }
        mMainRepository = MainRepository.instance
        mLiveData = mMainRepository!!.mutableLiveData
    }

    fun getmLiveData(): MutableLiveData<Response>? {
        return mLiveData
    }
}
