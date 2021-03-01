package com.ix.ibrahim7.dagger2application.util

import android.app.Application
import android.util.Log
import com.ix.ibrahim7.dagger2application.model.AppComponent
import com.ix.ibrahim7.dagger2application.model.DaggerAppComponent
import com.ix.ibrahim7.dagger2application.di.RetrofitModule
import com.ix.ibrahim7.dagger2application.other.*
import dagger.android.support.DaggerAppCompatActivity_MembersInjector.create

class MainApplication : Application() {

    private var appComponent: AppComponent? = null
    private var retrofitModel: RetrofitModule? = null

    override fun onCreate() {
        super.onCreate()
        appComponent = instance
        retrofitModel= appComponent!!.getNetComponent().build().getNetModel().getAppModule()

        val x = retrofitModel!!.NetModule(BASEURL)
        retrofitModel!!.provideRetrofit()

        Log.e("eeee url", x)
    }

    val instance: AppComponent by lazy {
        DaggerAppComponent.create()
    }


    fun getAppComponent(): AppComponent {
        return appComponent!!
    }

  /*  fun getApiInstance():RetrofitModule{
        return appComponent!!.getNetComponent().build().getNetModel().getAppModule()
    }*/


}