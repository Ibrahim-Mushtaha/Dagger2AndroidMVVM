package com.ix.ibrahim7.dagger2application.network

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetWork @Inject constructor() {


    fun getAppModule(): AppModule {
        return AppModule()
    }

}