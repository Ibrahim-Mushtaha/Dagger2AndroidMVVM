package com.ix.ibrahim7.dagger2application.model

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class River {


    /* @Inject*/
    // for view
    constructor(){
        Log.e("eee river ", "River")
    }

    fun getWeather(): String {
        return "Cloud"
    }
}