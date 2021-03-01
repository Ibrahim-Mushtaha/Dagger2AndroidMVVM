package com.ix.ibrahim7.dagger2application.util

import android.app.Application
import android.util.Log
import com.ix.ibrahim7.dagger2application.model.AppComponent
import com.ix.ibrahim7.dagger2application.model.DaggerAppComponent
import com.ix.ibrahim7.dagger2application.di.RetrofitModule
import com.ix.ibrahim7.dagger2application.network.Api
import com.ix.ibrahim7.dagger2application.other.*

class MainApplication : Application() {

    private var appComponent: AppComponent? = null

    lateinit var api: Api

    override fun onCreate() {
        super.onCreate()
        appComponent = instance

        val url = RetrofitModule.NetModule(BASEURL)
        val retrofit =RetrofitModule.provideRetrofit()
        api = retrofit!!.create(Api::class.java)
        Log.e("eeee url", url)
    }

    val instance: AppComponent by lazy {
        DaggerAppComponent.create()
    }


    fun getAppComponent(): AppComponent {
        return appComponent!!
    }




}