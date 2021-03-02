package com.ix.ibrahim7.dagger2application.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.ix.ibrahim7.dagger2application.R
import com.ix.ibrahim7.dagger2application.network.Api
import com.ix.ibrahim7.dagger2application.other.*
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
    fun provideRetrofit(url:String)=
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url)
            .build()

    @Provides
    @Singleton
    fun getPostApiInstance(): Api? {
        return provideRetrofit(BASEURL).create(Api::class.java)
    }

    @Provides
    @Singleton
    fun getCounrtyApiInstance(): Api? {
        return provideRetrofit(COUNRTYURL).create(Api::class.java)
    }

    @Singleton
    @Provides
    fun provideGlideInstance(
        context: Context
    ) = Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
           .error(R.drawable.ic_launcher_background)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
    )

}