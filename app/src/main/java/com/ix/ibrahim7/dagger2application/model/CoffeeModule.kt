package com.ix.ibrahim7.dagger2application.model

import android.util.Log
import dagger.Module
import dagger.Provides

@Module
class CoffeeModule {

    @Provides
    fun provideRiver():River{
        Log.e("eee provideRiver ", "provideRiver")
        return River()
    }

}