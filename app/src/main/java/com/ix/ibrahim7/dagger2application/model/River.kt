package com.ix.ibrahim7.dagger2application.model

import android.util.Log
import javax.inject.Inject

class River {

    @Inject
    constructor(){
        Log.e("eee river ", "River")
    }

    fun getWeather(): String {
        return "Cloud"
    }
}