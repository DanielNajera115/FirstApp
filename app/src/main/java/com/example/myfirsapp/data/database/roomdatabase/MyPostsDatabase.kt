package com.example.myfirsapp.data.database.roomdatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myfirsapp.data.database.dao.PostsDao
import com.example.myfirsapp.data.database.entity.MyPosts


/**
 * Created by dnajera on 05/2021.
 * Insulet Corporation
 * Andromeda
 */
@Database(entities = [MyPosts::class], version = 1, exportSchema = false)
abstract class MyPostsDatabase : RoomDatabase() {

    abstract fun wordDao(): PostsDao

    companion object {
        @Volatile
        private var INSTANCE: MyPostsDatabase? = null

        fun getDatabase(context: Context): MyPostsDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyPostsDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}