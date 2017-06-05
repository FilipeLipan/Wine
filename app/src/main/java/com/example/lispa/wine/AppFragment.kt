package com.example.lispa.wine

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem

/**
 * Created by lispa on 04/06/2017.
 */
object public abstract class AppFragment : Fragment() {

    private var mContext: Context? = null;
    private var mActivity: AppCompatActivity? = null;


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        this.mContext = context;

        if (context is AppCompatActivity) {
            this.mActivity = context
        }
    }

    fun replaceAndBackStackFragment(fragment :AppFragment, tag :String ){
        var ft :FragmentTransaction = fragmentManager.beginTransaction()
        ft.replace(R.id.container, fragment, tag)
        ft.addToBackStack(tag)
        ft.commit()
    }

    fun showHomeButton(){
        mActivity!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    fun hideHomeButton(){
        mActivity!!.supportActionBar!!.setDisplayHomeAsUpEnabled(false)
    }

    fun onBackPressed(){
        var activity :Activity = mContext as Activity
        activity.onBackPressed()
    }

}