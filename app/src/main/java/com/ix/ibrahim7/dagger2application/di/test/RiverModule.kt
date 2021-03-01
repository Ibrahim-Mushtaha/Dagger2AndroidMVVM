package com.ix.ibrahim7.dagger2application.di.test

import android.util.Log
import com.ix.ibrahim7.dagger2application.di.test.River
import com.ix.ibrahim7.dagger2application.other.TAG
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RiverModule() {

    @Singleton
    @Provides
    fun provideRiver(): River {
        Log.e("$TAG provideRiver ", "provideRiver")
        return River()
    }

   /* @Provides
    fun provideSuger():Int{
        Log.e("eee provideRiver ", "provideRiver")
        return suger
    }
*/
}