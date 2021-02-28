package com.ix.ibrahim7.dagger2application.util

import android.app.Application
import com.ix.ibrahim7.dagger2application.model.AppComponent
import com.ix.ibrahim7.dagger2application.model.DaggerAppComponent

class MainApplication  : Application() {

    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()
        appComponent= instance
    }

    val instance: AppComponent by lazy {
        DaggerAppComponent.create()
    }


     fun getAppComponent():AppComponent{
        return appComponent!!
    }




}