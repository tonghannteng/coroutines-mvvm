package com.tengtonghann.android.coroutines_mvvm.model.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    suspend fun getPostResponse(): Response<List<Post>>
}