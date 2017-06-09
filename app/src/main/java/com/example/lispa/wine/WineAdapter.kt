package com.example.lispa.wine

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.list_item.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by lispa on 04/06/2017.
 */
class WineAdapter (var wines :MutableList<Wine>) : RecyclerView.Adapter<WineAdapter.ViewHolder>() {

    fun setWine (wines :MutableList<Wine>){
        this.wines = wines;
        notifyDataSetChanged()
    }

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
            itemView.tv_type.text = wine.corte

            itemView.fab_delete.setOnClickListener {

                RestClient.restApi!!.deleteWine(wine.id.toString()).enqueue(object : Callback<Wine> {
                    override fun onResponse(call: Call<Wine>, response: Response<Wine>) {
                        if(response.isSuccessful){
                            Toast.makeText(context, "Deu certo excluir", Toast.LENGTH_SHORT).show()
//                            WineSingleton.removeWine(wine)
                            notifyItemRemoved(layoutPosition)
                        }
                    }

                    override fun onFailure(call: Call<Wine>, t: Throwable) {
                        Toast.makeText(context, "Deu ruim excluir", Toast.LENGTH_SHORT).show()
                    }
                })
            }
        }
    }
}