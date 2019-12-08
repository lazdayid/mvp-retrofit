package com.lazday.mvpretrofit.ui.main

import android.util.Log
import com.lazday.poslaravel.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(val view: MainContract.View):
    MainContract.Presenter {

    lateinit var callEmployee: Call<List<MainModel>>

    init {
        view.initActivity()
    }

    override fun getEmployee() {
        view.onLoading(true)
        callEmployee = ApiService.endpoint.getEmployees()
        callEmployee.enqueue(object : Callback<List<MainModel>>{
            override fun onFailure(call: Call<List<MainModel>>, t: Throwable) {
                Log.d("AgentPresenter", t.toString())
                view.onLoading(false)
            }

            override fun onResponse(
                call: Call<List<MainModel>>,
                response: Response<List<MainModel>>
            ) {
                view.onLoading(false)
                if (response.isSuccessful) {
                    val mainModel: List<MainModel>? = response.body()
                    view.onResult(mainModel!!)
                }
            }

        })
    }

    override fun onDestroy(){
        callEmployee.cancel()
    }
}