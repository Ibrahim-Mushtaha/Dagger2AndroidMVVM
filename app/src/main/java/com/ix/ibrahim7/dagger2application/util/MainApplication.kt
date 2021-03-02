package com.ix.ibrahim7.dagger2application.util

import android.app.Application
import android.util.Log
import com.ix.ibrahim7.dagger2application.di.Component.AppComponent
import com.ix.ibrahim7.dagger2application.di.Component.DaggerAppComponent
import com.ix.ibrahim7.dagger2application.di.module.RetrofitModule
import com.ix.ibrahim7.dagger2application.network.Api
import com.ix.ibrahim7.dagger2application.other.*

class MainApplication : Application() {

    private var appComponent: AppComponent? = null

    override fun onCreate() {
        super.onCreate()

        appComponent = instance

       /* RetrofitModule.provideRetrofit(BASEURL)
        RetrofitModule.provideRetrofit(COUNRTYURL)*/
    }

    val instance: AppComponent by lazy {
        DaggerAppComponent.create()
    }


    fun getAppComponent(): AppComponent {
        return appComponent!!
    }


}