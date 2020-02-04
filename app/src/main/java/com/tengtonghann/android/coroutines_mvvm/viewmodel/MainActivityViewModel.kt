package com.tengtonghann.android.coroutines_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tengtonghann.android.coroutines_mvvm.model.repository.PostRepository
import com.tengtonghann.android.coroutines_mvvm.model.retrofit.Post

class MainActivityViewModel : ViewModel() {

    private val postRepository = PostRepository()

    fun getPostResponse(): MutableLiveData<List<Post>> {
        return postRepository.getPostResponse()
    }

    fun getProgressBar(): MutableLiveData<Boolean> {
        return postRepository.progressBar
    }

    fun getMessage(): MutableLiveData<String> {
        return postRepository.message
    }

}