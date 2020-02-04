package com.tengtonghann.android.coroutines_mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tengtonghann.android.coroutines_mvvm.R
import com.tengtonghann.android.coroutines_mvvm.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainActivityViewModel: MainActivityViewModel

    companion object {
        const val TAG = "MainActivityLog"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        mainActivityViewModel.getPostResponse().observe(this, Observer { postListResponse ->
            recyclerViewPost.also {
                it.layoutManager = LinearLayoutManager(this)
                it.setHasFixedSize(true)
                it.adapter = postListResponse.body()?.let {
                    it1 -> PostAdapter(it1)
                }
            }
//            Log.d(TAG, it.size.toString())
        })

        mainActivityViewModel.progressBar.observe(this, Observer {
            progressBarId.visibility = if (it) View.VISIBLE else View.GONE
        })

        mainActivityViewModel.message.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })

    }
}
