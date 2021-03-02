package com.ix.ibrahim7.dagger2application.di.module

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ix.ibrahim7.dagger2application.network.Api
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
object RetrofitModule {

    var mBaseUrl: String? = null
    lateinit var retrofit: Retrofit

    // Constructor needs one parameter to instantiate.
    fun NetModule(baseUrl: String?):String {
        mBaseUrl = baseUrl
        return mBaseUrl!!
    }

    // Dagger will only look for methods annotated with @Provides
    @Provides
    @Singleton
    fun  // Application reference must come from AppModule.class
            providesSharedPreferences(application: Application?): SharedPreferences? {
        return PreferenceManager.getDefaultSharedPreferences(application)
    }

    @Provides
    @Singleton
    fun provideOkHttpCache(application: Application): Cache? {
        val cacheSize = 10 * 1024 * 1024 // 10 MiB
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @Singleton
    fun provideGson(): Gson? {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(cache: okhttp3.Cache?): OkHttpClient? {
        val client = OkHttpClient.Builder()
        client.cache(cache)
        return client.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit? {
        Log.e("eee","Retrofit")
        retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(mBaseUrl)
            .build()
        return retrofit
    }

    @Provides
    @Singleton
    fun getApiInstance(): Api? {
        return provideRetrofit()!!.create(Api::class.java)
    }

}