package com.example.lispa.wine

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.view.Menu
import android.view.MenuItem
import java.lang.reflect.Array


val listFragmentTAG:String = "listFragmentTAG"
val addWineFragmentTAG:String = "addWineFragmentTAG"
class MainActivity : AppCompatActivity() {

    var wines :MutableList<Wine> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fragmentManager :FragmentManager = supportFragmentManager
        if(savedInstanceState == null){
            fragmentManager.beginTransaction().add(R.id.container , ListWineFragment(), listFragmentTAG).commit();
        }else{
            fragmentManager.beginTransaction().replace(R.id.container, fragmentManager.findFragmentByTag(listFragmentTAG)).commit();
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.getItemId()) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
