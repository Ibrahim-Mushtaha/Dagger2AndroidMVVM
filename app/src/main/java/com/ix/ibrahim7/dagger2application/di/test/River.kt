package com.ix.ibrahim7.dagger2application.di.test

import android.util.Log
import com.ix.ibrahim7.dagger2application.other.TAG
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class River {


    /* @Inject*/
    // for view
    constructor(){
        Log.e("$TAG river ", "River")
    }

    fun getWeather(): String {
        return "Cloud"
    }
}