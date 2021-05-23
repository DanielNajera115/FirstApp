package com.example.myfirsapp.utils.dependencyinjection

import android.app.Application
import com.example.myfirsapp.data.FireBaseRepository
import com.example.myfirsapp.data.SignInRepositoryImpl
import com.example.myfirsapp.data.database.dao.PostsDao
import com.example.myfirsapp.data.database.roomdatabase.MyPostsDatabase
import com.example.myfirsapp.data.repositories.RedditInsertPostRepositoryImpl
import com.example.myfirsapp.data.repositories.RedditRepoImpl
import com.example.myfirsapp.domain.repositories.RedditInsertPostRepository
import com.example.myfirsapp.domain.repositories.RedditRepo
import com.example.myfirsapp.domain.repositories.SignInRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton


/**
 * Created by dnajera on 05/2021.
 * Insulet Corporation
 * Andromeda
 */

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideSignInRepository() : SignInRepository = SignInRepositoryImpl(FireBaseRepository())

    @Singleton
    @Provides
    fun provideRedditRepo() : RedditRepo = RedditRepoImpl()

    @Singleton
    @Provides
    fun providesRedditInsertPostRepository(application: Application) : RedditInsertPostRepository = RedditInsertPostRepositoryImpl(MyPostsDatabase.getDatabase(application).wordDao())

}