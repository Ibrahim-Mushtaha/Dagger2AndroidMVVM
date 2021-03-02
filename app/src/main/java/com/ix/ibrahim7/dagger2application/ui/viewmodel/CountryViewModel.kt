package com.ix.ibrahim7.dagger2application.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ix.ibrahim7.dagger2application.model.country.Country
import com.ix.ibrahim7.dagger2application.other.TAG
import com.ix.ibrahim7.dagger2application.repository.Repository
import com.ix.ibrahim7.dagger2application.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CountryViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {


    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
    val dataCountrysLiveData = MutableLiveData<Resource<Country>>()


    private suspend fun getCountrys() {
        dataCountrysLiveData.postValue(Resource.Loading())
        try {
            val response = repository
                .getCountry()
            dataCountrysLiveData.postValue(getCountry(response))
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    dataCountrysLiveData.postValue(Resource.Error(t.message.toString()))
                }
                else -> {
                    dataCountrysLiveData.postValue(Resource.Error(t.message.toString()))
                }

            }
        }
    }

    private fun getCountry(response: Response<Country>):
            Resource<Country> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


    fun getCountry() =
        viewModelScope.launch(dispatcher) {
            getCountrys()
        }

    init {
        Log.e("$TAG repository",repository.toString())
        getCountry()
    }

    fun getpost() = repository.getPost()
}