package com.ix.ibrahim7.dagger2application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ix.ibrahim7.dagger2application.model.Coffee
import com.ix.ibrahim7.dagger2application.model.DaggerCoffeeComponent
import com.ix.ibrahim7.dagger2application.model.Farm
import com.ix.ibrahim7.dagger2application.model.River

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            val x=DaggerCoffeeComponent.create().getCoffee()

        val farm= Farm()
        val river= River()
        val coffee= Coffee(farm, river)
    }
}