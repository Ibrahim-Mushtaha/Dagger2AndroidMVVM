package com.ix.ibrahim7.dagger2application.di.module

import com.ix.ibrahim7.dagger2application.ui.fragment.PostFragment
import dagger.Module
import javax.inject.Inject


@Module
class FragmentModule {


    @Inject
    fun injectfragment(postFragment: PostFragment){}

}