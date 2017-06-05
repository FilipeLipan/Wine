package com.example.lispa.wine

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.NavUtils
import kotlinx.android.synthetic.main.add_wine_fragment.*
import kotlinx.android.synthetic.main.add_wine_fragment.view.*

/**
 * Created by lispa on 04/06/2017.
 */
class AddWineFragment() : AppFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view :View = inflater!!.inflate(R.layout.add_wine_fragment, container, false);
        showHomeButton()

        view.bt_add_wine.setOnClickListener {
            WineSingleton.addWine(Wine(et_name.text.toString(), et_type.text.toString()))
            onBackPressed()
        }

        return view
    }

    override fun onDetach() {
        super.onDetach()
        hideHomeButton()
    }

}