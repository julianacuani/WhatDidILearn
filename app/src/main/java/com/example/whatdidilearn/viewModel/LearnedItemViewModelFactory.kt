package com.example.whatdidilearn.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whatdidilearn.data.LearnedItemDao

//Fábrica de objetos
class LearnedItemViewModelFactory(private val dao: LearnedItemDao): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LearnedItemViewModel::class.java)) {
            return LearnedItemViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}