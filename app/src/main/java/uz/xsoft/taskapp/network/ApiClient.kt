package uz.xsoft.taskapp.network

import android.util.Log
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.readystatesoftware.chuck.ChuckInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.xsoft.taskapp.BuildConfig.BASE_API_URL
import uz.xsoft.taskapp.BuildConfig.LOGGING
import uz.xsoft.taskapp.app.App


object ApiClient {
    @JvmStatic
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_API_URL)
        .client(getHttpClient())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    @JvmStatic
    private fun getHttpClient(): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addLogging()
        return httpClient.build()
    }


}

fun OkHttpClient.Builder.addLogging(): OkHttpClient.Builder {
    val context = App.appInstance
    val logging = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
        Log.d("TTT", it)
    })
    logging.level = HttpLoggingInterceptor.Level.BODY
    if (LOGGING) {
        addInterceptor(logging)
        addInterceptor(ChuckInterceptor(context))
    }
    return this
}




/*
fun isConnected(): Boolean {
    try {
        val e = App.appInstance.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as android.net.ConnectivityManager
        val activeNetwork = e.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    } catch (e: Exception) {
        e.printStackTrace()
    }

    return false
}*/
