package com.tengtonghann.android.coroutines_mvvm.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tengtonghann.android.coroutines_mvvm.R
import com.tengtonghann.android.coroutines_mvvm.model.retrofit.Post
import kotlinx.android.synthetic.main.post_items.view.*

class PostAdapter(private val posts: List<Post>): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_items, parent, false)
        return PostViewHolder(view)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    class PostViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(post: Post) {
            itemView.userId.text = post.userId.toString()
            itemView.textId.text = post.id.toString()
            itemView.titleId.text = post.title
            itemView.bodyId.text = post.body
        }
    }
}