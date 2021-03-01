package com.ix.ibrahim7.dagger2application.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ix.ibrahim7.dagger2application.R
import com.ix.ibrahim7.dagger2application.model.*
import com.ix.ibrahim7.dagger2application.ui.viewmodel.PostViewModel
import com.ix.ibrahim7.dagger2application.util.MainApplication
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var coffee: Coffee

    @Inject
    lateinit var coffee2: Coffee

    @Inject lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (application as MainApplication).getAppComponent()

        val coffeeComponent2 =
            appComponent.getCoffeeComponentBuilder().suger(4).build()
        coffeeComponent2.apply {
            inject(this@MainActivity)
            getCoffee()
        }

        Log.e("eee viewmodel",postViewModel.toString())
        Log.e("eee viewmodel",postViewModel.postRepository.toString())
        postViewModel.getpost()


       // val x=appComponent.getNetComponent().build().getNetModel().getAppModule().NetModule("wetwet")




        Log.e("eeee", coffee.getCoffeeCup() + "\ncoffee 1=$coffee" + " || " + "\ncoffee 2=$coffee2" + "\nriver for coffee1=${coffee.river}" + " || " + "\nriver for coffee2=${coffee2.river}")

        btnSave.setOnClickListener {
            //coffeeComponent2.inject(this)
            Log.e("eeee", coffee.getCoffeeCup() + "coffee 1=$coffee" + " || " + "coffee 2=$coffee2")
        }
    }

}