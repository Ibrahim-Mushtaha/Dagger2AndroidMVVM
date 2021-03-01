package com.ix.ibrahim7.dagger2application.model

import com.ix.ibrahim7.dagger2application.di.NetComponent
import com.ix.ibrahim7.dagger2application.di.RetrofitModule
import com.ix.ibrahim7.dagger2application.di.test.CoffeeComponent
import com.ix.ibrahim7.dagger2application.di.test.RiverModule
import com.ix.ibrahim7.dagger2application.util.MainApplication
import dagger.Component
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(modules = [RiverModule::class, RetrofitModule::class])
interface AppComponent : AndroidInjector<MainApplication> {

    fun getCoffeeComponentBuilder(): CoffeeComponent.Builder
    //fun getNetComponent(): NetComponent.Builder



}