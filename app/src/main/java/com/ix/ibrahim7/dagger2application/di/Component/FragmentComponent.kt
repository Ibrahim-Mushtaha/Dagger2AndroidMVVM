package com.ix.ibrahim7.dagger2application.di.Component

import com.ix.ibrahim7.dagger2application.di.annotations.ActivityScope
import com.ix.ibrahim7.dagger2application.ui.fragment.PostFragment
import com.ix.ibrahim7.dagger2application.ui.fragment.dialog.CountryDialog
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface FragmentComponent {

    fun injectfragment(fragment: PostFragment)
    fun injectDialog(countryDialog: CountryDialog)

    @Subcomponent.Builder
    interface Builder{
        fun build(): FragmentComponent
    }

}