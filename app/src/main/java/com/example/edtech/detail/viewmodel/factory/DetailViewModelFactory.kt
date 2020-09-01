package com.example.edtech.detail.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.edtech.detail.repository.DetailRepository
import com.example.edtech.detail.viewmodel.DetailViewModel
import com.example.edtech.main.repository.MainRepository
import com.example.edtech.main.viewmodel.MainViewModel

@Suppress("UNCHECKED_CAST")
class DetailViewModelFactory(
    private val repository: DetailRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DetailViewModel(repository) as T
    }
}