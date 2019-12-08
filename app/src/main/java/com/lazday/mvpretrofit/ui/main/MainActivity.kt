package com.lazday.mvpretrofit.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lazday.mvpretrofit.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var mainAdapter: MainAdapter
    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainAdapter =
            MainAdapter(this, arrayListOf())
        mainPresenter = MainPresenter(this)
        mainPresenter.getEmployee()
    }

    override fun initActivity() {
        recyclerView.apply { layoutManager = LinearLayoutManager(context)
            adapter = mainAdapter
        }
    }

    override fun onLoading(loading: Boolean) {
        when(loading) {
            true -> progressBar.visibility = View.VISIBLE
            false -> progressBar.visibility = View.GONE
        }
    }

    override fun onResult(mainModel: List<MainModel>) {
        if (mainModel.isNullOrEmpty()) {
            showMessage("Data tidak ditemukan")
        } else {
            mainAdapter.setData(mainModel)
        }
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT)
    }
}
