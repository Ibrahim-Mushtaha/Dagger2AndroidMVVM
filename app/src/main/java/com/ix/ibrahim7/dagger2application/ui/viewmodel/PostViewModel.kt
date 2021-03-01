package com.ix.ibrahim7.dagger2application.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ix.ibrahim7.dagger2application.model.post.PostItem
import com.ix.ibrahim7.dagger2application.other.TAG
import com.ix.ibrahim7.dagger2application.repository.PostRepository
import com.ix.ibrahim7.dagger2application.util.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {


    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
    val dataPostLiveData = MutableLiveData<Resource<List<PostItem>>>()

    init {
        Log.e("$TAG repository",postRepository.toString())
    }

    private suspend fun getPosts() {
        dataPostLiveData.postValue(Resource.Loading())
        try {
            val response = postRepository
                .getPost2()
            dataPostLiveData.postValue(getPost(response))
        } catch (t: Throwable) {
            when (t) {
                is IOException -> {
                    dataPostLiveData.postValue(Resource.Error(t.message.toString()))
                }
                else -> {
                    dataPostLiveData.postValue(Resource.Error(t.message.toString()))
                }

            }
        }
    }

    private fun getPost(response: Response<List<PostItem>>):
            Resource<List<PostItem>> {
        if (response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }
        return Resource.Error(response.message())
    }


    fun getPost() =
        viewModelScope.launch(dispatcher) {
            getPosts()
        }

    init {
        getPost()
    }

    fun getpost() = postRepository.getPost()
}