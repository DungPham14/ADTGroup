package com.androidtest.adtgroup.api

object ApiUtils {

    val BASE_URL = "http://admin.adtdisplay.vn"

    val service: ApiService
        get() = Client.getClient(BASE_URL).create(ApiService::class.java!!)

}
