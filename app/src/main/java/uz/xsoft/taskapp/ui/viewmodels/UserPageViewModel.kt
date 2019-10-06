package uz.xsoft.taskapp.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import kotlinx.coroutines.launch
import uz.xsoft.taskapp.data.repository.AppRepository
import uz.xsoft.taskapp.room.entity.UserData
import uz.xsoft.taskapp.ui.viewmodels.base.BaseViewModel
import androidx.paging.PagedList
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class UserPageViewModel(appRepository: AppRepository) : BaseViewModel(appRepository) {
    private val factory = appRepository.userDao.getAllPaged()
    private val config = PagedList.Config.Builder()
        .setEnablePlaceholders(true)
        .setPrefetchDistance(8)
        .setPageSize(10).build()

    val userListLiveData: LiveData<PagedList<UserData>> = LivePagedListBuilder<Int, UserData>(factory, config).build()
}