package com.ix.ibrahim7.dagger2application.di.module

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import dagger.Module
import dagger.Provides


@Module
object GlideModule {


    val glideContextName = "glide context"

    @Provides
    fun provideGlide(context: View): RequestManager? {
        return Glide.with(context)
    }

}