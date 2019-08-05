package com.androidtest.adtgroup.api

import com.androidtest.adtgroup.model.Response
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService {
    @GET("/api/v1/home?deviceId=33&orientation=0")
    fun getData(@Header("Authorization") token: String): Call<Response>
}
