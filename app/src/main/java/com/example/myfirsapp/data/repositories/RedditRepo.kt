package com.example.myfirsapp.data.repositories

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.myfirsapp.data.models.RedditPost
import com.example.myfirsapp.data.network.RedditClient
import com.example.myfirsapp.data.network.RedditService
import kotlinx.coroutines.flow.Flow

class RedditRepo(context: Context){

    private val redditService = RedditClient.getClient().create(RedditService::class.java)

    // 2
    fun fetchPosts(): Flow<PagingData<RedditPost>> {
        // 3
        return Pager(
            PagingConfig(pageSize = 40, enablePlaceholders = false)
        ) {
            RedditPagingSource(redditService)
        }.flow
    }

}