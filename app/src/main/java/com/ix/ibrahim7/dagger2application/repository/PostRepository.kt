package com.ix.ibrahim7.dagger2application.repository

import android.app.Application
import android.net.Network
import android.util.Log
import com.ix.ibrahim7.dagger2application.di.NetComponent
import com.ix.ibrahim7.dagger2application.di.NetWork
import com.ix.ibrahim7.dagger2application.di.RetrofitModule
import com.ix.ibrahim7.dagger2application.network.Api
import com.ix.ibrahim7.dagger2application.util.MainApplication
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepository @Inject constructor() {


    val x= RetrofitModule.mBaseUrl
    suspend fun getPost2() = RetrofitModule.getApiInstance()!!.getPost()


    fun getPost(){
        Log.e(
            "eeee RetrofitModule",x.toString()
        )
        Log.e("eee post","post 1")
    }
}