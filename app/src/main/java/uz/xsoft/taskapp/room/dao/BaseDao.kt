package uz.xsoft.taskapp.room.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDao<T> {
    @Update
    fun update( data: T)

    @Delete
    fun delete( data: T)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert( data: T): Long
}