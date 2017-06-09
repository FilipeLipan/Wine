package com.example.lispa.wine

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.support.v4.app.NavUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.add_wine_fragment.*
import kotlinx.android.synthetic.main.add_wine_fragment.view.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by lispa on 04/06/2017.
 */
class AddWineFragment() : AppFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view :View = inflater!!.inflate(R.layout.add_wine_fragment, container, false);
        showHomeButton()

        view.bt_add_wine.setOnClickListener {
//            WineSingleton.addWine(Wine(et_name.text.toString(), et_type.text.toString()))

            val wine: Wine = Wine(view.et_name.text.toString(), view.et_type.text.toString(),
                    view.et_temperature.text.toString().toInt(), view.et_shelf_life.text.toString().toInt(), view.et_crop.text.toString().toInt())

            RestClient.restApi!!.saveWine(wine).enqueue(object : Callback<ResponseBody> {
                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if(response.isSuccessful){
                        Toast.makeText(context, "Deu certo", Toast.LENGTH_SHORT).show()
                        onBackPressed()
                    }
                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Toast.makeText(context, "Deu ruim", Toast.LENGTH_SHORT).show()
                }
            })
        }

        return view
    }

    override fun onDetach() {
        super.onDetach()
        hideHomeButton()
    }

}