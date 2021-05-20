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
@Database(entities = arrayOf(MyPosts::class), version = 1, exportSchema = false)
public abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao(): PostsDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: WordRoomDatabase? = null

        fun getDatabase(context: Context): WordRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WordRoomDatabase::class.java,
                    "post_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}