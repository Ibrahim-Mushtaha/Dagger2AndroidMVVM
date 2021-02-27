package com.ix.ibrahim7.dagger2application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ix.ibrahim7.dagger2application.model.*
import com.ix.ibrahim7.dagger2application.util.MainApplication
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var coffee: Coffee

    @Inject
    lateinit var coffee2: Coffee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appComponent = (application as MainApplication).getAppComponent()

        val coffeeComponent2 =
            DaggerCoffeeComponent.builder().suger(4).appComponent(appComponent).build()
        coffeeComponent2.apply {
            inject(this@MainActivity)
            getCoffee()
        }

        Log.e("eeee", coffee.getCoffeeCup() + "\ncoffee 1=$coffee" + " || " + "\ncoffee 2=$coffee2" + "\nriver for coffee1=${coffee.river}" + " || " + "\nriver for coffee2=${coffee2.river}")

        btnSave.setOnClickListener {
            //coffeeComponent2.inject(this)
            Log.e("eeee", coffee.getCoffeeCup() + "coffee 1=$coffee" + " || " + "coffee 2=$coffee2")
        }
    }

}