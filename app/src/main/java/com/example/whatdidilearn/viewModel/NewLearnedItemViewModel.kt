package com.example.whatdidilearn.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.whatdidilearn.data.LearnedItemDao
import com.example.whatdidilearn.entities.ItemLearned
import com.example.whatdidilearn.entities.Level
import com.example.whatdidilearn.repository.LearnedItemsRepository
import kotlinx.coroutines.launch

class NewLearnedItemViewModel(private var repository: LearnedItemsRepository): ViewModel() {
    fun insertNewLearnedItem(itemTitle: String, itemDescription: String) {
        viewModelScope.launch{
            val item = ItemLearned(itemTitle, itemDescription, Level.HIGH)
            repository.insertNewLearnedItem(item)
        }
    }
}
