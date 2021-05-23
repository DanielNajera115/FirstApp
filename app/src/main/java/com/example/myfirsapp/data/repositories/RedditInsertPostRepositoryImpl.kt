package com.example.myfirsapp.data.repositories

import com.example.myfirsapp.data.database.dao.PostsDao
import com.example.myfirsapp.data.database.entity.MyPosts
import com.example.myfirsapp.domain.repositories.RedditInsertPostRepository
import javax.inject.Inject

/**
 * Created by dnajera on 05/2021.
 * Insulet Corporation
 * Andromeda
 */
class RedditInsertPostRepositoryImpl @Inject constructor(private val postsDao: PostsDao) : RedditInsertPostRepository {
    override suspend fun invoke(myPosts: MyPosts) {
        postsDao.insert(myPosts)
    }
}