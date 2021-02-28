package com.ix.ibrahim7.dagger2application.network

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetWork @Inject constructor() {


    @Inject
    fun getAppModule(): AppModule {
        Log.e("eee net name:", "espresso coffee")
        return AppModule()
    }

}