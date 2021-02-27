package com.ix.ibrahim7.dagger2application.model

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@ActivityScope
class Farm {

    @Inject
    constructor(){
        Log.e("eee farm ", "Farm")
    }

    fun getBeans(): String {
        return "Beans"
    }

}