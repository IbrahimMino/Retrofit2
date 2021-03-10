package com.example.retrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.data.User
import kotlinx.android.synthetic.main.row_item.view.*


class RvAdapter(var list:List<User>):RecyclerView.Adapter<RvAdapter.ViewHolder>() {

    inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        fun onBind(user:User){
            itemView.tv_id.text = user.id.toString()
             itemView.tv_name.text = user.name
            itemView.tv_email.text = user.email
            itemView.tv_website.text = user.website
            itemView.tv_company.text = user.company!!.name
          }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
     return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.onBind(list[position])
    }
}