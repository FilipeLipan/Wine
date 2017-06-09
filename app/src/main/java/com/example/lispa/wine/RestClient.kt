package com.example.lispa.wine

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by lispa on 05/06/2017.
 */
object RestClient {

    var restApi : RestApi? = null;

    init {
        val retrofitClient = Retrofit.Builder()
                .baseUrl(BuildConfig.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        restApi = retrofitClient?.create(RestApi::class.java)

    }
}