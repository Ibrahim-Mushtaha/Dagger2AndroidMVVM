package com.ix.ibrahim7.dagger2application.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.ix.ibrahim7.dagger2application.repository.PostRepository
import com.ix.ibrahim7.dagger2application.util.MainApplication
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostViewModel @Inject constructor(val postRepository: PostRepository) :ViewModel(){

    fun getpost() = postRepository.getPost()
}