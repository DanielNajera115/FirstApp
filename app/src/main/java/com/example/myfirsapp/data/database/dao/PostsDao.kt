package com.example.myfirsapp.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myfirsapp.data.database.entity.MyPosts
import kotlinx.coroutines.flow.Flow


/**
 * Created by dnajera on 05/2021.
 * Insulet Corporation
 * Andromeda
 */
@Dao
interface PostsDao {

    @Query("SELECT * FROM posts ORDER BY title ASC")
    fun getAllData(): Flow<List<MyPosts>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(myPosts: MyPosts)

}