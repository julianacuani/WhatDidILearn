package com.example.whatdidilearn.repository

import com.example.whatdidilearn.data.LearnedItemDao
import com.example.whatdidilearn.entities.ItemLearned

class LearnedItemsRepository(private val dao: LearnedItemDao) {
    val learnedItems = dao.getAll()

    suspend fun insertNewLearnedItem(item: ItemLearned) {
        dao.insert(item)
    }
}
