package com.example.lispa.wine

/**
 * Created by lispa on 04/06/2017.
 */
object WineSingleton {

    private val wines: MutableList<Wine> = mutableListOf();

    fun addWine(wine: Wine){
        wines.add(wine)
    }

    fun getWines() : MutableList<Wine>{
        return wines
    }

    fun removeWine(wine: Wine){
        wines.remove(wine)
    }

}