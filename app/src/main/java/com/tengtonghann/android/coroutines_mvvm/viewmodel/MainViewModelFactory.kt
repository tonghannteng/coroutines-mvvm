package com.tengtonghann.android.coroutines_mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tengtonghann.android.coroutines_mvvm.model.repository.PostRepository

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(private val postRepository: PostRepository) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(postRepository) as T
    }
}