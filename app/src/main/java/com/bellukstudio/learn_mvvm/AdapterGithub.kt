package com.bellukstudio.learn_mvvm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bellukstudio.learn_mvvm.network.DataGithub
import com.bumptech.glide.Glide

class AdapterGithub () : RecyclerView.Adapter<AdapterGithub.ViewHolder>() {

    private var listDataGithub: List<DataGithub>? = null
    fun setData(listDataGithub: List<DataGithub>?){
        this.listDataGithub = listDataGithub
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterGithub.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycle_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterGithub.ViewHolder, position: Int) {
        holder.bind(listDataGithub?.get(position)!!)
    }

    override fun getItemCount(): Int {
        return listDataGithub!!.size
    }

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val thumImage = view.findViewById<ImageView>(R.id.thumbImage)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvDesc = view.findViewById<TextView>(R.id.tvDesc)
        fun bind(data : DataGithub){
            tvName.text = data.name
            tvDesc.text = data.description
            Glide.with(thumImage).load(data.owner.avatar_url).into(thumImage)
        }

    }
}