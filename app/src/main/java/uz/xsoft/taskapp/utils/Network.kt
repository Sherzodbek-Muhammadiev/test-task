package uz.xsoft.taskapp.utils

import android.content.Context
import uz.xsoft.taskapp.app.App

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
}