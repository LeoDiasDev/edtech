package com.example.edtech.common.extensions

import java.text.SimpleDateFormat
import java.util.*

fun Calendar.formatToStringDate() : String{
    return SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).format(this.time)
}

