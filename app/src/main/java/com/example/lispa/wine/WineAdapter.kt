package com.example.lispa.wine

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.list_item.view.*

/**
 * Created by lispa on 04/06/2017.
 */
class WineAdapter (var wines :MutableList<Wine>, var context: Context) : RecyclerView.Adapter<WineAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val wine :Wine = wines.get(position);
        holder!!.bind(wine)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view :View = LayoutInflater.from(parent!!.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return wines.size
    }


    inner class ViewHolder(itemView :View) : RecyclerView.ViewHolder(itemView){
        fun bind(wine :Wine ) = with(itemView){
            itemView.tv_name.text = wine.name
            itemView.tv_type.text = wine.type

            itemView.fab_delete.setOnClickListener {
                WineSingleton.removeWine(wine)
                notifyItemRemoved(layoutPosition)
            }
        }
    }
}