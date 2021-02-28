package com.ix.ibrahim7.dagger2application.model

import com.ix.ibrahim7.dagger2application.network.AppModule
import com.ix.ibrahim7.dagger2application.network.NetComponent
import com.ix.ibrahim7.dagger2application.network.NetModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [RiverModule::class,NetModule::class, AppModule::class])
interface AppComponent {

    /*fun getRiver(): River*/
    fun getCoffeeComponentBuilder():CoffeeComponent.Builder
    fun getNetComponent(): NetComponent.Builder
}