package com.ix.ibrahim7.dagger2application.model

import android.util.Log
import javax.inject.Inject

class Coffee @Inject constructor(var farm: Farm,var river: River) {

    fun getCoffeeCup():String{
        return farm.getBeans()+" | "+river.getWeather()
    }


    @Inject
    fun getCoffeeName(){
        Log.e("eee coffee name:", "espresso coffee")
    }

}