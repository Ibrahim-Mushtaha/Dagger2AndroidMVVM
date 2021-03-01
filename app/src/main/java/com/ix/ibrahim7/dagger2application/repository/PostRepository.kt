package com.ix.ibrahim7.dagger2application.repository

import android.util.Log
import com.ix.ibrahim7.dagger2application.util.MainApplication
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepository @Inject constructor() {

    fun getPost(){
        Log.e("eee post","post 1")
    }
}