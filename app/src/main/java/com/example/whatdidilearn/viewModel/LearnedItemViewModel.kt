package com.example.whatdidilearn.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatdidilearn.entities.ItemLearned
import com.example.whatdidilearn.repository.LearnedItemsRepository
import kotlinx.coroutines.launch

class LearnedItemViewModel(private val repository: LearnedItemsRepository): ViewModel() {
        val learnedItemsList: LiveData<List<ItemLearned>>
    init {
        learnedItemsList = repository.learnedItems
    }
    fun insertNewLearnedItem(item: ItemLearned) {
        viewModelScope.launch {
            repository.insertNewLearnedItem(item)
        }
    }
}