package uz.xsoft.taskapp.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(@LayoutRes resId:Int) = LayoutInflater.from(context).inflate(resId,this,false)

fun ViewGroup.addView(@LayoutRes resId:Int) : View {
    val view = inflate(resId)
    addView(view)
    return view
}