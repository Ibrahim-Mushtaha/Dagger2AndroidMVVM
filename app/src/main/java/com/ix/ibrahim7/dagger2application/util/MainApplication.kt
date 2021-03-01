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
     var retrofitModel: RetrofitModule? = null


    lateinit var api: Api

    override fun onCreate() {
        super.onCreate()
        appComponent = instance
        retrofitModel= appComponent!!.getNetComponent().build().getNetModel().getAppModule()

        val x = retrofitModel!!.NetModule(BASEURL)
        val retrofit =retrofitModel!!.provideRetrofit()
        api = retrofit!!.create(Api::class.java)
        Log.e("eeee url", x)
    }

    val instance: AppComponent by lazy {
        DaggerAppComponent.create()
    }


    fun getAppComponent(): AppComponent {
        return appComponent!!
    }




}