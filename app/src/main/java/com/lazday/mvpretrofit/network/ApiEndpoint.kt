package com.lazday.poslaravel.network

import com.lazday.mvpretrofit.ui.main.MainModel
import retrofit2.Call
import retrofit2.http.*

interface ApiEndpoint {

    @GET("employees")
    fun getEmployees(): Call<List<MainModel>>
}