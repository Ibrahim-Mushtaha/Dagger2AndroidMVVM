package com.ix.ibrahim7.dagger2application.model

import android.app.Application
import com.ix.ibrahim7.dagger2application.di.NetComponent
import com.ix.ibrahim7.dagger2application.di.RetrofitModule
import com.ix.ibrahim7.dagger2application.util.MainApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Singleton


@Singleton
@Component(modules = [RiverModule::class, RetrofitModule::class])
interface AppComponent : AndroidInjector<MainApplication> {

    fun getCoffeeComponentBuilder():CoffeeComponent.Builder
    fun getNetComponent(): NetComponent.Builder



}