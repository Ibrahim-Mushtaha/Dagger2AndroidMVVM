package com.ix.ibrahim7.dagger2application.di.test

import com.ix.ibrahim7.dagger2application.di.annotations.ActivityScope
import com.ix.ibrahim7.dagger2application.ui.MainActivity
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
        fun suger(suger:Int): Builder
        fun build(): CoffeeComponent
    }

}