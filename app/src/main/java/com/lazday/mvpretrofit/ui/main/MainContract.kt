package com.lazday.mvpretrofit.ui.main

import com.lazday.mvpretrofit.ui.main.MainModel


interface MainContract {

    interface Presenter {
        fun getEmployee()
        fun onDestroy()
    }

    interface View {
        fun initActivity()
        fun onLoading(loading: Boolean)
        fun onResult(mainModel: List<MainModel>)
        fun showMessage(message: String)
    }
}