package com.ix.ibrahim7.dagger2application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ix.ibrahim7.dagger2application.model.*
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var coffee: Coffee
    lateinit var coffeeComponent: CoffeeComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnSave.setOnClickListener {
            coffeeComponent = DaggerCoffeeComponent.builder().coffeeModule(CoffeeModule(etxtNumber.text.toString().toInt())).build()
            coffeeComponent.inject(this)
            Log.e("eeee", coffee.getCoffeeCup())
        }


    }
}