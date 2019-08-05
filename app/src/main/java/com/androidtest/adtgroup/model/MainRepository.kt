package com.androidtest.adtgroup.model

import android.arch.lifecycle.MutableLiveData
import android.util.Log

import com.androidtest.adtgroup.api.ApiService
import com.androidtest.adtgroup.api.ApiUtils

import retrofit2.Call
import retrofit2.Callback

class MainRepository {
    private val mService: ApiService
    private val mMutableLiveData = MutableLiveData<Response>()

    val mutableLiveData: MutableLiveData<Response> get() {
            mService.getData(TOKEN).enqueue(object : Callback<Response> {
                override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {
                    val y = response.code()
                    Log.d("MainRepository", y.toString())
                    if (response.isSuccessful) {
                        Log.d("MainRepository", response.body().count!!.toString())
                        mMutableLiveData.value = response.body()
                    }
                }

                override fun onFailure(call: Call<Response>, t: Throwable) {

                }
            })
            return mMutableLiveData
        }

    init {
        mService = ApiUtils.service
    }

    companion object {
        private var mRepository: MainRepository? = null
        private val TOKEN = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6MzYsImlzQWN0aXZlIjp0cnVlfQ.Pgq2WTdzdUGEo9Cys4qUsmfniowPU8akbCgiDSePy-Y"

        val instance: MainRepository
            get() {
                if (mRepository == null) {
                    mRepository = MainRepository()
                }
                return mRepository!!
            }
    }
}
