package com.ix.ibrahim7.dagger2application.di.Component

import com.ix.ibrahim7.dagger2application.di.annotations.ActivityScope
import com.ix.ibrahim7.dagger2application.ui.fragment.PostFragment
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface FragmentComponent {

    fun injectfragment(fragment: PostFragment)

    @Subcomponent.Builder
    interface Builder{
        fun build(): FragmentComponent
    }

}