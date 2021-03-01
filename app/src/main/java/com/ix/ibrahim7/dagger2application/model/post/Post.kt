package com.ix.ibrahim7.dagger2application.model.post

import com.google.gson.annotations.SerializedName

data class AllPost(
    var  list:ArrayList<PostItem>?
)

data class PostItem(
    @SerializedName("userId")
    val userId: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)