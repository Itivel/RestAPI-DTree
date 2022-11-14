package com.levi.restapi_dtree

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class layerAdapter(val context: Context, val userlist: List<dataGroup1Item>):RecyclerView.Adapter<layerAdapter.ViewHolder> {
    class ViewHolder(dataView: View): RecyclerView.ViewHolder(dataView) {

        var NAME: TextView
        var SURNAME: TextView
        var AGE: TextView
        var CITY: TextView

        init {
            name = dataView.name

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       var dataView = LayoutInflater.from(context).inflate(R.layout.row_dataitems, parent, attachToRoot: false)
        return ViewHolder(dataView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.name.text = userlist[position].name.tostring()
        holder.SURNAME.text = userlist[position].SURNAME.tostring()
    }

    override fun getItemCount(): Int {
        return userlist.size
    }
}