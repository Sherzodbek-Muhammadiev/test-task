package uz.xsoft.taskapp.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var name: String,
    val date: Long
)