package com.tengtonghann.android.coroutines_mvvm.model.repository

import androidx.lifecycle.MutableLiveData
import com.tengtonghann.android.coroutines_mvvm.model.retrofit.Post
import com.tengtonghann.android.coroutines_mvvm.model.retrofit.PostService
import com.tengtonghann.android.coroutines_mvvm.model.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Response

class PostRepository {

    var postList = ArrayList<Post>()
    var postMutableLiveData = MutableLiveData<List<Post>>()
    val progressBar = MutableLiveData<Boolean>()
    val message = MutableLiveData<String>()

    private val postService: PostService = RetrofitInstance.postService

    fun getPostResponse(): MutableLiveData<List<Post>> {
        postService.getPostResponse().enqueue(object : retrofit2.Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                postList = response.body() as ArrayList<Post>
                postMutableLiveData.postValue(postList)
                progressBar.postValue(false)
                message.postValue("Successfully")

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                // Handle Failure
                progressBar.postValue(false)
                message.postValue("Failed")
            }

        })
        return postMutableLiveData
    }

}