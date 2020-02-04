package com.tengtonghann.android.coroutines_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.tengtonghann.android.coroutines_mvvm.model.repository.PostRepository
import java.io.IOException

class MainActivityViewModel(private val postRepository: PostRepository) : ViewModel() {

    private val mProgressBar = MutableLiveData<Boolean>()
    private val mMessage = MutableLiveData<String>()

    fun getPostResponse() = liveData {
        try {
            emit(postRepository.getPostResponse())
            mProgressBar.postValue(false)
            mMessage.postValue("Successfully")
        } catch (ioException: IOException) {
            mProgressBar.postValue(false)
            mMessage.postValue("Failed")
        }

    }

    fun getProgressBar(): MutableLiveData<Boolean>{
        return mProgressBar
    }

    fun getMessage(): MutableLiveData<String> {
        return mMessage
    }

}