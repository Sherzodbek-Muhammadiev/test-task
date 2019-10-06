package uz.xsoft.taskapp.room.dao

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import uz.xsoft.taskapp.room.entity.ItemData
import uz.xsoft.taskapp.room.entity.UserData

@Dao
interface ItemDao : BaseDao<ItemData> {
    @Query("SELECT * FROM items ORDER BY id DESC")
    fun getAllPaged(): DataSource.Factory<Int, ItemData>
}