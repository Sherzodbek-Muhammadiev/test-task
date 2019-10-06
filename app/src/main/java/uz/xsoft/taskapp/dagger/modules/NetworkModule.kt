package uz.xsoft.taskapp.dagger.modules

import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import uz.xsoft.taskapp.network.ApiClient
import uz.xsoft.taskapp.network.api.AdvertisementApi

@Module
object NetworkModule{

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideAdvertisementApi(retrofit: Retrofit): AdvertisementApi {
        return retrofit.create(AdvertisementApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit  = ApiClient.retrofit
}