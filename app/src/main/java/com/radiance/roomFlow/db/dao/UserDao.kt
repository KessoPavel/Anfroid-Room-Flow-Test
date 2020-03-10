package com.radiance.roomFlow.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.radiance.roomFlow.db.enity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): Flow<List<User>>

    @Insert
    fun insertAll(vararg users: User)

    @Delete
    fun delete(user: User)
}