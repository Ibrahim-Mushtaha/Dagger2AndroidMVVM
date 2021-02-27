package com.ix.ibrahim7.dagger2application.model

import com.ix.ibrahim7.dagger2application.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [RiverModule::class])
interface AppComponent {

    /*fun getRiver(): River*/
    fun getCoffeeComponentBuilder():CoffeeComponent.Builder
}