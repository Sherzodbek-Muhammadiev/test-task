package uz.xsoft.taskapp.dagger.components

import dagger.Component
import uz.xsoft.taskapp.dagger.modules.NetworkModule
import uz.xsoft.taskapp.data.repository.AppRepository
import uz.xsoft.taskapp.data.repository.impl.AppRepositoryImpl
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(appRepository: AppRepositoryImpl)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}