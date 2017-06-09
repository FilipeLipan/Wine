package com.example.lispa.wine

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Toast
import kotlinx.android.synthetic.main.list_wine_fragment.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by lispa on 04/06/2017.
 */
class ListWineFragment (): AppFragment() {

    var adapter: WineAdapter = WineAdapter(mutableListOf());

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view :View = inflater!!.inflate(R.layout.list_wine_fragment, container, false);

        view.rv_main.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.rv_main.adapter = WineAdapter(WineSingleton.getWines())

        RestClient.restApi!!.getWines().enqueue(object : Callback<ArrayList<Wine>> {
            override fun onResponse(call: Call<ArrayList<Wine>>?, response: Response<ArrayList<Wine>>?) {
                if(response!!.isSuccessful){
                    adapter.setWine(response.body())
                }else{
                    Toast.makeText(context , "something went wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ArrayList<Wine>>?, t: Throwable?) {
                Toast.makeText(context , "something went wrong", Toast.LENGTH_SHORT).show()
            }

        })

        view.fab_add.setOnClickListener {
            replaceAndBackStackFragment(AddWineFragment(), addWineFragmentTAG)
        }

        return view
    }


}