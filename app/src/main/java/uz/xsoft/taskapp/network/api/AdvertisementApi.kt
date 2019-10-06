package uz.xsoft.taskapp.network.api

import retrofit2.http.GET
import retrofit2.http.Query
import uz.xsoft.taskapp.network.models.ResponseData

interface AdvertisementApi {
    @GET("show/app/60")
    suspend fun getAdvertisements(@Query("uuid") uuid:String = "fghy123sdasdasdasdasafgdfgdfa",@Query("secret") secret:String = "bqgqkbxgOaU3pPEt"): ResponseData.AdvertisementData

}