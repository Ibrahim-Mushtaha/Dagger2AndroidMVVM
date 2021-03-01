package com.ix.ibrahim7.dagger2application.di

import com.ix.ibrahim7.dagger2application.model.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent()
interface NetComponent {

   fun getNetModel(): NetWork

    @Subcomponent.Builder
    interface Builder{

        fun build(): NetComponent
        //fun appComponent(appComponent: AppComponent):Builder
    }

}