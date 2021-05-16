package com.example.myfirsapp.domain.repositories

import androidx.paging.PagingData
import com.example.myfirsapp.data.models.RedditPost
import kotlinx.coroutines.flow.Flow

/**
 * Created by dnajera on 05/2021.
 * Insulet Corporation
 * Andromeda
 */
interface RedditRepo {
    operator fun invoke() : Flow<PagingData<RedditPost>>
}