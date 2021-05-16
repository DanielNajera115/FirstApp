package com.example.myfirsapp.presentation.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.myfirsapp.data.models.RedditPost
import com.example.myfirsapp.domain.repositories.RedditRepo
import kotlinx.coroutines.flow.Flow

class RedditViewModel@ViewModelInject constructor(
        private val redditRepo : RedditRepo
) : ViewModel() {
    fun fetchPosts(): Flow<PagingData<RedditPost>> {
        return redditRepo().cachedIn(viewModelScope)
    }
}