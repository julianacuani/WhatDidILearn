package com.example.whatdidilearn.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.whatdidilearn.repository.LearnedItemsRepository

//Fábrica de objetos
class LearnedItemViewModelFactory(private val repository: LearnedItemsRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LearnedItemViewModel::class.java)) {
            return LearnedItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

class NewLearnedItemViewModelFactory(private val repository: LearnedItemsRepository) : ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewLearnedItemViewModel::class.java)) {
            return NewLearnedItemViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
