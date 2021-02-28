package com.ix.ibrahim7.dagger2application.model

import com.ix.ibrahim7.dagger2application.MainActivity
import dagger.BindsInstance
import dagger.Subcomponent

@ActivityScope
@Subcomponent()
interface CoffeeComponent {

    fun getCoffee(): Coffee

    fun inject(mainActivity: MainActivity)

    @Subcomponent.Builder
    interface Builder{

        @BindsInstance
        fun suger(suger:Int):Builder
        fun build():CoffeeComponent
        //fun appComponent(appComponent: AppComponent):Builder
    }

}