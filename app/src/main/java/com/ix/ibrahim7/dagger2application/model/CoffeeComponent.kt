package com.ix.ibrahim7.dagger2application.model

import com.ix.ibrahim7.dagger2application.MainActivity
import com.ix.ibrahim7.dagger2application.model.Coffee
import dagger.Component

@Component
interface CoffeeComponent {

    fun getCoffee(): Coffee

    fun inject(mainActivity: MainActivity)

}