package com.ix.ibrahim7.dagger2application.model

import com.ix.ibrahim7.dagger2application.MainActivity
import com.ix.ibrahim7.dagger2application.model.Coffee
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoffeeModule::class])
interface CoffeeComponent {

    fun getCoffee(): Coffee

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun suger(suger:Int):Builder
        fun build():CoffeeComponent
    }

}