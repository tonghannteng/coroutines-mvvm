package com.tengtonghann.android.coroutines_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tengtonghann.android.coroutines_mvvm.model.repository.PostRepository
import java.io.IOException

class MainActivityViewModel : ViewModel() {

    var progressBar = MutableLiveData<Boolean>()
    var message = MutableLiveData<String>()
    private val postRepository = PostRepository()

    fun getPostResponse() = liveData {
        try {
            emit(postRepository.getPostResponse())
            progressBar.postValue(false)
            message.postValue("Successfully")
        } catch (ioException: IOException) {
            progressBar.postValue(false)
            message.postValue("Failed")
        }

    }

}