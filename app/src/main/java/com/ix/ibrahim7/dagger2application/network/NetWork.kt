package com.ix.ibrahim7.dagger2application.network

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetWork @Inject constructor() {


    fun getAppModule(): RetrofitModule {
        return RetrofitModule()
    }

}