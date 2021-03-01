package com.ix.ibrahim7.dagger2application.network

import com.ix.ibrahim7.dagger2application.di.annotations.ActivityScope
import com.ix.ibrahim7.dagger2application.model.post.PostItem
import com.ix.ibrahim7.dagger2application.other.*
import retrofit2.Response
import retrofit2.http.GET

@ActivityScope
interface Api {

    @GET(POSTS)
    suspend fun getPost(): Response<List<PostItem>>


}