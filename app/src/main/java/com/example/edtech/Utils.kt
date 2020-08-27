package com.example.edtech

import java.text.SimpleDateFormat
import java.util.*

object Utils{

    fun getData(date : String) : String{
        val formato = SimpleDateFormat("yyyy-MM-dd", Locale("pt-BR"))
        val data = formato.parse(date)
        formato.applyPattern("dd/MM/yyyy")
        return formato.format(data!!)
    }

    fun getYearfromDate(date : String) : String{
        val dateSplit =  date.split("-")
        return dateSplit[0]
    }

    fun RemoveLastStr(str: String?): String? {
        var str = str
        if (str != null && str.isNotEmpty() && str[str.length - 1] == 'x') {
            str = str.substring(0, str.length - 1)
        }
        return str
    }

}