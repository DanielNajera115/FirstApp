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
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reddit_rows, parent, false)
        return RedditViewHolder(view)
    }

    override fun onBindViewHolder(holder: RedditViewHolder, position: Int) {
        getItem(position)?.let { redditPost ->
            holder.bindPost(redditPost)
        }
    }

    class RedditViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val scoreText: TextView = itemView.findViewById(R.id.tvStars)
        private val commentsText: TextView = itemView.findViewById(R.id.tvComments)
        private val titleText: TextView = itemView.findViewById(R.id.tvPostMessage)

        fun bindPost(redditPost: RedditPost) {
            with(redditPost) {
                scoreText.text = score.toString()
                commentsText.text = commentCount.toString()
                titleText.text = title
            }
        }
    }
}