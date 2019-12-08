package com.lazday.mvpretrofit.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lazday.mvpretrofit.R
import kotlinx.android.synthetic.main.adapter_main.view.*


class MainAdapter (val context: Context, var dataAgent: ArrayList<MainModel>):
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.adapter_main,
                parent, false
            )
        )

    override fun getItemCount() = dataAgent.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bing(dataAgent[position])

    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val view = view
        fun bing(mainModel: MainModel){
            view.textView.text = mainModel.employee_name
        }
    }

    fun setData(mainModel: List<MainModel>){
        dataAgent.clear()
        dataAgent.addAll(mainModel)
        notifyDataSetChanged()
    }
}