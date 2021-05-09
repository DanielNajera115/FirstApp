package com.example.myfirsapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirsapp.R
import com.example.myfirsapp.data.models.RedditPost
import com.example.myfirsapp.presentation.DiffUtilCallBack

class RedditAdapter: PagingDataAdapter<RedditPost, RedditAdapter.RedditViewHolder>(DiffUtilCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RedditViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reddit_rows,parent,false)
        return RedditViewHolder(view)
    }

    override fun onBindViewHolder(holder: RedditViewHolder, position: Int) {
        getItem(position)?.let { redditPost ->
            holder.bindPost(redditPost)
        }
    }

    class RedditViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        private val scoreTextView = itemView.findViewById<TextView>(R.id.tvStars)
        private val messageTextView = itemView.findViewById<TextView>(R.id.tvComments)
        private val postTextView = itemView.findViewById<TextView>(R.id.tvPostMessage)

        fun bindPost(redditPost: RedditPost){
            with(redditPost){
                scoreTextView.text = score.toString()
                messageTextView.text = commentCount.toString()
                postTextView.text = title
            }
        }

    }




}