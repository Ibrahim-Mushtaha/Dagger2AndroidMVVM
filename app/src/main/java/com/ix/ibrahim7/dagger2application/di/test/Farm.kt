package com.ix.ibrahim7.dagger2application.di.test

import android.util.Log
import com.ix.ibrahim7.dagger2application.di.annotations.ActivityScope
import com.ix.ibrahim7.dagger2application.other.TAG
import javax.inject.Inject

@ActivityScope
class Farm {

    @Inject
    constructor(){
        Log.e("$TAG farm ", "Farm")
    }

    fun getBeans(): String {
        return "Beans"
    }

}