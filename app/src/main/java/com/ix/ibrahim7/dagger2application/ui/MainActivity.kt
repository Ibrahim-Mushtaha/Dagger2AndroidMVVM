package com.ix.ibrahim7.dagger2application.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ix.ibrahim7.dagger2application.R
import com.ix.ibrahim7.dagger2application.di.factory.ViewModelFactory
import com.ix.ibrahim7.dagger2application.di.test.Coffee
import com.ix.ibrahim7.dagger2application.ui.viewmodel.PostViewModel
import com.ix.ibrahim7.dagger2application.util.MainApplication
import com.ix.ibrahim7.dagger2application.util.Resource
import com.ix.ibrahim7.dagger2application.other.*
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var coffee: Coffee

    @Inject
    lateinit var coffee2: Coffee

    @Inject
    lateinit var viewModeFactory: ViewModelFactory<PostViewModel>

    private val viewModel: PostViewModel by lazy {
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



        viewModel.getpost()


        viewModel.dataPostLiveData.observe(this, Observer {
            when (it) {
                is Resource.Success -> {
                    it.data?.let { data ->
                        Log.e("$TAG posts", it.data.toString())
                    }
                }

                is Resource.Error -> {
                    Log.e("$TAG Error", it.message.toString())
                }
                is Resource.Loading -> {

                }
            }
        })




        Log.e(
            TAG,
            coffee.getCoffeeCup() + "\ncoffee 1=$coffee" + " || " + "\ncoffee 2=$coffee2" + "\nriver for coffee1=${coffee.river}" + " || " + "\nriver for coffee2=${coffee2.river}"
        )

        btnSave.setOnClickListener {
            Log.e(TAG, coffee.getCoffeeCup() + "coffee 1=$coffee" + " || " + "coffee 2=$coffee2")
        }
    }

}