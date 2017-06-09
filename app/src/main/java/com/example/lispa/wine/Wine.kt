package com.example.lispa.wine

import com.google.gson.annotations.SerializedName

/**
 * Created by lispa on 04/06/2017.
 */
class Wine () {

    public var id: Int? = null
    @SerializedName("nome")
    public var name: String? = null
    public var corte: String? = null
    @SerializedName("temperatura")
    public var temeperature: Int = 0
    @SerializedName("validade")
    public var shelfLife: Int = 0
    @SerializedName("safra")
    public var crop: Int = 0

    constructor (id: Int?, name: String?, corte: String?, temeperature: Int, shelfLife: Int, crop: Int) : this() {
        this.id = id
        this.name = name
        this.corte = corte
        this.temeperature = temeperature
        this.shelfLife = shelfLife
        this.crop = crop
    }

    constructor (name: String?, corte: String?, temeperature: Int, shelfLife: Int, crop: Int) : this() {
        this.id = null
        this.name = name
        this.corte = corte
        this.temeperature = temeperature
        this.shelfLife = shelfLife
        this.crop = crop
    }


}