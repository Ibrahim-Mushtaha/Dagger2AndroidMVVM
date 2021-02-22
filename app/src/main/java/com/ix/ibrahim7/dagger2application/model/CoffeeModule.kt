package com.ix.ibrahim7.dagger2application.model

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class CoffeeModule(var suger: Int) {

    @Provides
    fun provideRiver():River{
        Log.e("eee provideRiver ", "provideRiver")
        return River()
    }

    @Provides
    fun provideSuger():Int{
        Log.e("eee provideRiver ", "provideRiver")
        return suger
    }

}