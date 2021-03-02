package com.ix.ibrahim7.dagger2application.repository

import android.util.Log
import com.ix.ibrahim7.dagger2application.di.module.RetrofitModule
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor() {


    suspend fun getPost2() = RetrofitModule.getPostApiInstance()!!.getPost()
    suspend fun getCountry() = RetrofitModule.getCounrtyApiInstance()!!.getCountry()


    fun getPost(){
        Log.e(
            "eeee RetrofitModule",
            RetrofitModule.mBaseUrl.toString())
        Log.e("eee post","post 1")
    }
}