package com.ix.ibrahim7.dagger2application.di

import com.ix.ibrahim7.dagger2application.di.annotations.ActivityScope
import dagger.Subcomponent

@ActivityScope
@Subcomponent()
interface NetComponent {

    @Subcomponent.Builder
    interface Builder{

        fun build(): NetComponent
    }

}