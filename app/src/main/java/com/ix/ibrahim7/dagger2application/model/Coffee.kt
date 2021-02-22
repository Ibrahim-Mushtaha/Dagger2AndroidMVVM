package com.ix.ibrahim7.dagger2application.model

import android.util.Log
import javax.inject.Inject

class Coffee @Inject constructor(var farm: Farm,var river: River,var sugar:Int) {

    fun getCoffeeCup():String{
        return farm.getBeans()+" | "+river.getWeather()+ " | suger :"+ sugar
    }


    @Inject
    fun getCoffeeName(){
        Log.e("eee coffee name:", "espresso coffee")
    }

}