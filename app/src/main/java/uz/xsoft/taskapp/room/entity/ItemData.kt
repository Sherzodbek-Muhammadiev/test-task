package uz.xsoft.taskapp.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class ItemData(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var name: String,
    val date: Long
)