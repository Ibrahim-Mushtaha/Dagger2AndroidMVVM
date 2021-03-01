package com.ix.ibrahim7.dagger2application.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProviders
import com.ix.ibrahim7.dagger2application.R
import com.ix.ibrahim7.dagger2application.di.factory.ViewModelFactory
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

    @Inject lateinit var viewModeFactory: ViewModelFactory<PostViewModel>

    private val viewModel : PostViewModel by lazy {
        ViewModelProviders.of(this, viewModeFactory).get(PostViewModel::class.java)
    }


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

        Log.e("eee viewmodel",viewModel.toString())

        viewModel.getpost()






        Log.e("eeee", coffee.getCoffeeCup() + "\ncoffee 1=$coffee" + " || " + "\ncoffee 2=$coffee2" + "\nriver for coffee1=${coffee.river}" + " || " + "\nriver for coffee2=${coffee2.river}")

        btnSave.setOnClickListener {
            Log.e("eeee", coffee.getCoffeeCup() + "coffee 1=$coffee" + " || " + "coffee 2=$coffee2")
        }
    }

}