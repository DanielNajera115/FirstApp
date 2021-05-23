package com.example.myfirsapp.presentation.viewmodels

import android.app.Application
import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirsapp.data.database.entity.MyPosts
import com.example.myfirsapp.domain.repositories.RedditInsertPostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Created by dnajera on 05/2021.
 * Insulet Corporation
 * Andromeda
 */
class RedditPostingViewModel @ViewModelInject constructor(
        application: Application,
        private val redditInsertPostRepository: RedditInsertPostRepository
) : AndroidViewModel(application) {

    fun insert(myPosts: MyPosts){
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("Reddit", "hello")
            redditInsertPostRepository(myPosts)
        }
    }
}