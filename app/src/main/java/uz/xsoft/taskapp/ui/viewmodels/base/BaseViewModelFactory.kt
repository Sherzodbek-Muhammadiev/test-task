package uz.xsoft.taskapp.ui.viewmodels.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.xsoft.taskapp.data.repository.AppRepository

class BaseViewModelFactory(private val appRepository: AppRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(AppRepository::class.java).newInstance(appRepository)
    }
}