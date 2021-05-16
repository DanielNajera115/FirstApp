package com.example.myfirsapp.data.repositories

import android.content.Context
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.myfirsapp.data.models.RedditPost
import com.example.myfirsapp.data.network.RedditClient
import com.example.myfirsapp.data.network.RedditService
import com.example.myfirsapp.domain.repositories.RedditRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn

class RedditRepoImpl() : RedditRepo{

    private val redditService = RedditClient.getClient().create(RedditService::class.java)

    override fun invoke() : Flow<PagingData<RedditPost>>{
        return Pager(
                PagingConfig(pageSize = 40, enablePlaceholders = false)
        ) {
            RedditPagingSource(redditService)
        }.flow.flowOn(Dispatchers.IO)
    }
}