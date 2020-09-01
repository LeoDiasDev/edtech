package com.example.edtech.common.extensions

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Context.getAdapterToSpinnerFromArrayString(idRawRes: Int): ArrayAdapter<String> {
    val list = Gson().fromJson(
        this.resources.openRawResource(idRawRes).bufferedReader(),
        Array<String>::class.java
    )

    return ArrayAdapter(
        this,
        android.R.layout.simple_spinner_dropdown_item,
        list
    )
}

fun Context.getArrayStringFromRaw(idRawRes: Int): Array<String> {
    val list = Gson().fromJson(
        this.resources.openRawResource(idRawRes).bufferedReader(),
        Array<String>::class.java
    )

    return list
}

fun Context.getDatePicker(inputDate: TextInputEditText) {
    inputDate.text?.clear()
    var calendar = Calendar.getInstance()
    val dialog = DatePickerDialog(
        this,
        DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, monthOfYear)
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            inputDate.setText(calendar.formatToStringDate())
        },
        calendar.get(Calendar.YEAR),
        calendar.get(Calendar.MONTH),
        calendar.get(Calendar.DAY_OF_MONTH)
    )

    dialog.datePicker.minDate = calendar.timeInMillis
    dialog.show()
}

fun Context.getData(date : String) : String{
    val formato = SimpleDateFormat("yyyy-MM-dd", Locale("pt-BR"))
    val data = formato.parse(date)
    formato.applyPattern("dd/MM/yyyy")
    return formato.format(data!!)
}

@SuppressLint("SimpleDateFormat")
fun Context.getTimePicker(inputTime: TextInputEditText) {
    inputTime.text?.clear()
    val calendar = Calendar.getInstance()
    TimePickerDialog(
        this,
        TimePickerDialog.OnTimeSetListener { _, hour, minute ->
            calendar.set(Calendar.HOUR_OF_DAY, hour)
            calendar.set(Calendar.MINUTE, minute)
            inputTime.setText(SimpleDateFormat("HH:mm").format(calendar.time))
        },
        calendar.get(Calendar.HOUR_OF_DAY),
        calendar.get(Calendar.MINUTE),
        true
    ).show()
}

