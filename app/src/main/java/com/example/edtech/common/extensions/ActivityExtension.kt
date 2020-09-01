package com.example.edtech.common.extensions

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import java.text.SimpleDateFormat
import java.util.*

fun Activity.showToastMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun AppCompatActivity.transactionFragment(doFunction: FragmentTransaction.() -> Unit) {
    val transaction = supportFragmentManager.beginTransaction()
    doFunction(transaction)
    transaction.commit()
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Activity.getData(date : String) : String{
    val formato = SimpleDateFormat("yyyy-MM-dd", Locale("pt-BR"))
    val data = formato.parse(date)
    formato.applyPattern("dd/MM/yyyy")
    return formato.format(data!!)
}

fun Activity.getYearfromDate(date : String) : String{
    val dateSplit =  date.split("-")
    return dateSplit[0]
}
