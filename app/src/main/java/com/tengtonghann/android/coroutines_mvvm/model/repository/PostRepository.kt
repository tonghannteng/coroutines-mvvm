package com.tengtonghann.android.coroutines_mvvm.model.repository

import com.tengtonghann.android.coroutines_mvvm.model.retrofit.Post
import com.tengtonghann.android.coroutines_mvvm.model.retrofit.PostService
import com.tengtonghann.android.coroutines_mvvm.model.retrofit.RetrofitInstance
import retrofit2.Response

class PostRepository {

    private val postService: PostService = RetrofitInstance.postService

    suspend fun getPostResponse(): Response<List<Post>> = postService.getPostResponse()

}