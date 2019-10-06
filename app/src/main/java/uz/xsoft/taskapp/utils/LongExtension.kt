package uz.xsoft.taskapp.utils

import java.text.SimpleDateFormat
import java.util.*

fun Long.date(pattern: String = "yyyy-MM-dd HH:mm:ss"): String? = SimpleDateFormat(pattern,  Locale.getDefault()).format(this)