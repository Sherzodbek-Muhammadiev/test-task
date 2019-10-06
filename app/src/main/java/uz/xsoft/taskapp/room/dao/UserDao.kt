package uz.xsoft.taskapp.room.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import uz.xsoft.taskapp.room.entity.UserData

@Dao
interface UserDao : BaseDao<UserData> {
    @Query("SELECT * FROM users ORDER BY id DESC")
    fun getAllPaged(): DataSource.Factory<Int, UserData>

    @Query("SELECT * FROM users LIMIT :beginIndex,:endIndex")
    fun getUserByLimit(beginIndex: Int, endIndex: Int): List<UserData>
}