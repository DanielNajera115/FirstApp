package com.example.myfirsapp.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by dnajera on 05/2021.
 * Insulet Corporation
 * Andromeda
 */
@Entity(tableName = "posts")
data class MyPosts(
        @PrimaryKey @ColumnInfo(name = "id") val id : Int,
        @ColumnInfo(name = "title") val title: String,
        @ColumnInfo(name = "comment_count") val commentCount: Int,
        @ColumnInfo(name = "score") val score : String
        )