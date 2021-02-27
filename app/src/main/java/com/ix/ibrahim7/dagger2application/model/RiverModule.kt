package com.ix.ibrahim7.dagger2application.model

import android.util.Log
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RiverModule() {

    @Singleton
    @Provides
    fun provideRiver():River{
        Log.e("eee provideRiver ", "provideRiver")
        return River()
    }

   /* @Provides
    fun provideSuger():Int{
        Log.e("eee provideRiver ", "provideRiver")
        return suger
    }
*/
}