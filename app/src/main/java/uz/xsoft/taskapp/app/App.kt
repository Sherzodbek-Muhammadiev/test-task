package uz.xsoft.taskapp.app

import android.app.Application


class App  :  Application(){

    companion object{
        lateinit var appInstance : App
    }

    override fun onCreate() {
        super.onCreate()
        appInstance = this
    }
}
