package uz.xsoft.taskapp.ui.viewmodels.base

import androidx.lifecycle.ViewModel
import uz.xsoft.taskapp.data.repository.AppRepository

abstract class BaseViewModel(val appRepository: AppRepository) : ViewModel()