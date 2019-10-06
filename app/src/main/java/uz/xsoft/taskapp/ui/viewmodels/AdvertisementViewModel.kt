package uz.xsoft.taskapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.pwittchen.reactivenetwork.library.rx2.ReactiveNetwork
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import uz.xsoft.taskapp.app.App
import uz.xsoft.taskapp.data.repository.AppRepository
import uz.xsoft.taskapp.network.models.ResponseData
import uz.xsoft.taskapp.ui.viewmodels.base.BaseViewModel
import uz.xsoft.taskapp.utils.isConnected

class AdvertisementViewModel(appRepository: AppRepository) : BaseViewModel(appRepository) {
    val advertisementLiveData: LiveData<ResponseData.AdvertisementData> = appRepository.advertisementLiveData

    private val _errorLiveData = MutableLiveData<Boolean>()
    val errorLiveData: LiveData<Boolean> = _errorLiveData

    private val _progressLiveData = MutableLiveData<Boolean>()
    val progressLiveData: LiveData<Boolean> = _progressLiveData

    private val _reloadLiveData = MutableLiveData<Boolean>()
    val reloadLiveData: LiveData<Boolean> = _reloadLiveData

    init {
        if (isConnected()) {
            _progressLiveData.postValue(true)
        } else {
            _progressLiveData.postValue(false)
            _errorLiveData.postValue(advertisementLiveData.value == null)
        }
        advertisementLiveData.observeForever {
            _progressLiveData.postValue(false)
            _errorLiveData.postValue(false)
        }
        val t = ReactiveNetwork
            .observeInternetConnectivity()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { isConnectedToInternet ->
                _reloadLiveData.postValue(isConnectedToInternet)
                _errorLiveData.postValue(advertisementLiveData.value == null)
                if (advertisementLiveData.value == null && isConnectedToInternet) {
                    appRepository.loadAdvertisement()
                    _progressLiveData.postValue(true)
                    _errorLiveData.postValue(false)
                }
            }
    }

    fun reload() {
        if (isConnected()) {
            _progressLiveData.postValue(true)
            appRepository.loadAdvertisement()
        }
    }

}