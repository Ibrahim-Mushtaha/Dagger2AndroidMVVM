package com.ix.ibrahim7.dagger2application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ix.ibrahim7.dagger2application.model.Coffee
import com.ix.ibrahim7.dagger2application.model.DaggerCoffeeComponent
import com.ix.ibrahim7.dagger2application.model.Farm
import com.ix.ibrahim7.dagger2application.model.River
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var coffee: Coffee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val component = DaggerCoffeeComponent.create()
        component.inject(this)

        Log.e("eeee", coffee.getCoffeeCup())

    }
}