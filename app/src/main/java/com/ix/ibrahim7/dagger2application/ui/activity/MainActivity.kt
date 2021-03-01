package com.ix.ibrahim7.dagger2application.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ix.ibrahim7.dagger2application.databinding.ActivityMainBinding
import com.ix.ibrahim7.dagger2application.di.test.Coffee
import com.ix.ibrahim7.dagger2application.util.MainApplication
import com.ix.ibrahim7.dagger2application.other.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    lateinit var mBinding: ActivityMainBinding

    @Inject
    lateinit var coffee: Coffee

    @Inject
    lateinit var coffee2: Coffee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        val appComponent = (application as MainApplication).getAppComponent()

        val coffeeComponent2 =
            appComponent.getCoffeeComponentBuilder().suger(4).build()
        coffeeComponent2.apply {
            inject(this@MainActivity)
            getCoffee()
        }


        Log.e(
            TAG,
            coffee.getCoffeeCup() + "\ncoffee 1=$coffee" + " || " + "\ncoffee 2=$coffee2" + "\nriver for coffee1=${coffee.river}" + " || " + "\nriver for coffee2=${coffee2.river}"
        )


    }

}