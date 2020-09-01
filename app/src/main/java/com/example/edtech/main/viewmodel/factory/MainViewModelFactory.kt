package com.example.edtech.main.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.edtech.main.repository.MainRepository
import com.example.edtech.main.viewmodel.MainViewModel

@Suppress("UNCHECKED_CAST")
class MainViewModelFactory(
    private val repository: MainRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}