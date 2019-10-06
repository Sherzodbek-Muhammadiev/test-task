package uz.xsoft.taskapp.data.repository

import androidx.lifecycle.LiveData
import uz.xsoft.taskapp.network.models.ResponseData
import uz.xsoft.taskapp.room.dao.ItemDao
import uz.xsoft.taskapp.room.dao.UserDao

interface AppRepository {
    val userDao :UserDao
    val itemDao :ItemDao
    val advertisementLiveData: LiveData<ResponseData.AdvertisementData>
    fun loadAdvertisement()
}