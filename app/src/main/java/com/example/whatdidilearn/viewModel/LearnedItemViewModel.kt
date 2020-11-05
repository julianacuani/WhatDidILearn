package com.example.whatdidilearn.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.whatdidilearn.data.LearnedItemDao
import com.example.whatdidilearn.entities.ItemLearned

class LearnedItemViewModel(private val dao: LearnedItemDao): ViewModel() {
        val learnedItemsList: LiveData<List<ItemLearned>>
    init {
        learnedItemsList = dao.getAll()
    }
}