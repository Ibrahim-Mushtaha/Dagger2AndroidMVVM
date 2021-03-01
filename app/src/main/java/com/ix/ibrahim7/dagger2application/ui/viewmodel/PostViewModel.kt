package com.ix.ibrahim7.dagger2application.ui.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.ix.ibrahim7.dagger2application.repository.PostRepository
import com.ix.ibrahim7.dagger2application.util.MainApplication
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {

    init {
        Log.e("eeee repository",postRepository.toString())
    }

    fun getpost() = postRepository!!.getPost()
}