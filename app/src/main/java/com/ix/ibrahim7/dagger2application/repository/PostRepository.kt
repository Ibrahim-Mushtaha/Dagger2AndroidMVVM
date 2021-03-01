package com.ix.ibrahim7.dagger2application.repository

import android.util.Log
import com.ix.ibrahim7.dagger2application.util.MainApplication
import javax.inject.Inject

class PostRepository @Inject constructor() {

//    val x = MainApplication().getAppComponent()

    fun getPost(){
        Log.e("eee post","post 1")
    }
}