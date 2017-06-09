package com.example.lispa.wine

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*
import java.util.ArrayList

/**
 * Created by lispa on 05/06/2017.
 */
interface RestApi {

    @GET("vinho/")
    abstract fun getWines(): Call<ArrayList<Wine>>

    @PUT("vinho/")
    abstract fun changeWine(): Call<Wine>

    @POST("vinho/")
    abstract fun saveWine(@Body wine: Wine): Call<ResponseBody>

    @DELETE("vinho/{id}")
    abstract fun deleteWine(@Path("id") id: String): Call<Wine>
}