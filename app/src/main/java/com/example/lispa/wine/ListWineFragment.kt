package com.example.lispa.wine

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_wine_fragment.view.*

/**
 * Created by lispa on 04/06/2017.
 */
class ListWineFragment (): AppFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view :View = inflater!!.inflate(R.layout.list_wine_fragment, container, false);


        view.rv_main.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        view.rv_main.adapter = WineAdapter(WineSingleton.getWines(),context)


        view.fab_add.setOnClickListener {
            replaceAndBackStackFragment(AddWineFragment(), addWineFragmentTAG)
        }

        return view
    }


}