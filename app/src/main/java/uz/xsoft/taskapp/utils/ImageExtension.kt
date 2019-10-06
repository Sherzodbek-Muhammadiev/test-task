package uz.xsoft.taskapp.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.loadImageFromUrl(url:String){
    Picasso.get()
        .load(url)
        .resize(128, 128)
        .centerCrop()
        .into(this)
}