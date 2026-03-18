package com.blues.db.user

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * File: com.blues.db.user.UserDatabase.kt
 * Description: 数据库抽象类
 *
 * @author: lanhuajian
 * @time: 2022/1/20
 **/

@Database(entities = [User::class], version = 1)
abstract class UserDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        private const val DATABASE_NAME = "user_info"
        private lateinit var mUserDatabase: UserDatabase

        fun getInstance(context: Context): UserDatabase {
            if (!this::mUserDatabase.isInitialized) {
                mUserDatabase = Room.databaseBuilder(
                    context.applicationContext, UserDatabase::class.java,
                    DATABASE_NAME
                ).allowMainThreadQueries().build()
            }
            return mUserDatabase
        }
    }
}