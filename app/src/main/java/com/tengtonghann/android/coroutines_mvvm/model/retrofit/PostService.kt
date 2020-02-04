package com.tengtonghann.android.coroutines_mvvm.model.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun getPostResponse(): Call<List<Post>>
}