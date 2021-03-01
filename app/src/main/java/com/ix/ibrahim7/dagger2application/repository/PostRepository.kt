package com.ix.ibrahim7.dagger2application.repository

import android.util.Log
import com.ix.ibrahim7.dagger2application.di.RetrofitModule
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepository @Inject constructor() {


    suspend fun getPost2() = RetrofitModule.getApiInstance()!!.getPost()


    fun getPost(){
        Log.e(
            "eeee RetrofitModule",RetrofitModule.mBaseUrl.toString())
        Log.e("eee post","post 1")
    }
}