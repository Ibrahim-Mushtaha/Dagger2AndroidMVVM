package com.ix.ibrahim7.dagger2application.network

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import androidx.constraintlayout.solver.Cache
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ix.ibrahim7.dagger2application.model.CoffeeComponent
import com.ix.ibrahim7.dagger2application.model.River
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton


@Module
class NetModule {

   /* @Singleton
    @Provides
    fun provideNet(): Net {
        Log.e("eee provideNet ", "provideNet")
        return Net()
    }
*/
}