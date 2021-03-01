package com.ix.ibrahim7.dagger2application.di.test

import android.util.Log
import com.ix.ibrahim7.dagger2application.di.annotations.ActivityScope
import com.ix.ibrahim7.dagger2application.other.*
import javax.inject.Inject

@ActivityScope
class Coffee @Inject constructor(var farm: Farm, var river: River, var sugar:Int=0) {

    fun getCoffeeCup():String{
        return farm.getBeans()+" | "+river.getWeather()+ " | suger :"+ sugar
    }


    @Inject
    fun getCoffeeName(){
        Log.e("$TAG coffee name:", "espresso coffee")
    }

}