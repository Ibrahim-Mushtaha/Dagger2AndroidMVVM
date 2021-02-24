package com.ix.ibrahim7.dagger2application.util

import android.app.Application
import android.content.Context
import com.ix.ibrahim7.dagger2application.model.CoffeeComponent
import com.ix.ibrahim7.dagger2application.model.DaggerCoffeeComponent

class MainApplication  : Application() {

    private var coffeeComponent: CoffeeComponent? = null

    override fun onCreate() {
        super.onCreate()
        coffeeComponent= appComponent
    }

    val appComponent: CoffeeComponent by lazy {
        DaggerCoffeeComponent.builder().suger(5).build()
    }


     fun getCoffeeComponent():CoffeeComponent{
        return coffeeComponent!!
    }




}