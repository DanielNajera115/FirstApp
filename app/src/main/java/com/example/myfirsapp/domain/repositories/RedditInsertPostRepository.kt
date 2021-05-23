package com.example.myfirsapp.domain.repositories

import com.example.myfirsapp.data.database.entity.MyPosts

/**
 * Created by dnajera on 05/2021.
 * Insulet Corporation
 * Andromeda
 */
interface RedditInsertPostRepository {
    suspend operator fun invoke(myPosts: MyPosts)
}