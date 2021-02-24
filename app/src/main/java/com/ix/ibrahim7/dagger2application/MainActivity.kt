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

        val coffeeComponent2 =(application as MainApplication).getCoffeeComponent()
        coffeeComponent2.inject(this)
        coffeeComponent2.getCoffee()

        Log.e("eeee", coffee.getCoffeeCup()+"coffee 1=$coffee"+" || "+"coffee 2=$coffee2")

        btnSave.setOnClickListener {
            coffeeComponent2.inject(this)
            Log.e("eeee", coffee.getCoffeeCup()+"coffee 1=$coffee"+" || "+"coffee 2=$coffee2")
        }


    }
}