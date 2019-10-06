package uz.xsoft.taskapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.xsoft.taskapp.data.repository.AppRepository
import uz.xsoft.taskapp.room.entity.ItemData
import uz.xsoft.taskapp.room.entity.UserData
import uz.xsoft.taskapp.ui.viewmodels.base.BaseViewModel
import java.util.*

class MainViewModel(appRepository: AppRepository) : BaseViewModel(appRepository) {

    private val _addEnableHideLiveData = MutableLiveData<Unit>()
    val addEnableLiveData: LiveData<Unit> = _addEnableHideLiveData

    private val _addDisableLiveData = MutableLiveData<Unit>()
    val addDisableLiveData: LiveData<Unit> = _addDisableLiveData

    fun pageSelected(position: Int) {
        when (position) {
            0 -> {
                _addEnableHideLiveData.value = Unit
            }
            1 -> {
                _addDisableLiveData.value = Unit
            }
            2 -> {
                _addEnableHideLiveData.value = Unit
            }
        }
    }

    fun addData(position: Int) {
        when (position) {
            0 -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val user = UserData(0, "User", Calendar.getInstance().timeInMillis)
                    val id = appRepository.userDao.insert(user)
                    user.name = "User $id"
                    appRepository.userDao.update(user)
                }
            }
            1 -> {
                _addEnableHideLiveData.value = Unit
            }
            2 -> {
                viewModelScope.launch(Dispatchers.IO) {
                    val item = ItemData(0, "Item", Calendar.getInstance().timeInMillis)
                    val id = appRepository.itemDao.insert(item)
                    item.name = "Item $id"
                    appRepository.itemDao.update(item)
                }
            }
        }
    }
}