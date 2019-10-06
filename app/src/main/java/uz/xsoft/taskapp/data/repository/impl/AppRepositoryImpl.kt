package uz.xsoft.taskapp.data.repository.impl

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.xsoft.taskapp.dagger.components.DaggerViewModelInjector
import uz.xsoft.taskapp.dagger.modules.NetworkModule
import uz.xsoft.taskapp.data.repository.AppRepository
import uz.xsoft.taskapp.network.ApiClient
import uz.xsoft.taskapp.network.api.AdvertisementApi
import uz.xsoft.taskapp.network.models.ResponseData
import uz.xsoft.taskapp.room.AppDatabase
import uz.xsoft.taskapp.room.dao.ItemDao
import uz.xsoft.taskapp.room.dao.UserDao
import javax.inject.Inject

class AppRepositoryImpl(application: Application) : AndroidViewModel(application), AppRepository {
    @Inject
    lateinit var advertisementApi: AdvertisementApi

    init {
        DaggerViewModelInjector.builder().networkModule(NetworkModule).build().inject(this)
        loadAdvertisement()
    }

    //local
    private val database = AppDatabase.getDatabase(application, viewModelScope)
    override val userDao: UserDao = database.userDao()
    override val itemDao: ItemDao = database.itemDao()

    //remote
    private val _advertisementLiveData = MutableLiveData<ResponseData.AdvertisementData>()
    override val advertisementLiveData: LiveData<ResponseData.AdvertisementData> = _advertisementLiveData


    override fun loadAdvertisement() {
        GlobalScope.launch {
            try {
                val response = advertisementApi.getAdvertisements()
                    _advertisementLiveData.postValue(response)
                /*if (response.isSuccessful) {
                    val body = response.body()
                } else {
                    _advertisementLiveData.postValue(null)
                }*/
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}