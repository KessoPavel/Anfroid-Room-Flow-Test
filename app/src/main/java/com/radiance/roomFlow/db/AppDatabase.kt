package com.radiance.roomFlow.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.radiance.roomFlow.db.dao.UserDao
import com.radiance.roomFlow.db.enity.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}