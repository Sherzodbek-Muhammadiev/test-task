package uz.xsoft.taskapp.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import uz.xsoft.taskapp.data.repository.AppRepository
import uz.xsoft.taskapp.data.repository.impl.AppRepositoryImpl
import uz.xsoft.taskapp.ui.viewmodels.base.BaseViewModelFactory

fun appRepository(activity: FragmentActivity): AppRepository = ViewModelProviders.of(activity)[AppRepositoryImpl::class.java]
inline fun <reified T : ViewModel> Fragment.factoryViewModel() = lazy { ViewModelProviders.of(this, BaseViewModelFactory(appRepository(activity!!)))[T::class.java] }
inline fun <reified T : ViewModel> Fragment.appRepository() = lazy { appRepository(activity!!) }
inline fun <reified T : ViewModel> FragmentActivity.factoryViewModel() = lazy { ViewModelProviders.of(this, BaseViewModelFactory(appRepository(this)))[T::class.java] }
inline fun <reified T : ViewModel> FragmentActivity.appRepository() = lazy { appRepository(this) }