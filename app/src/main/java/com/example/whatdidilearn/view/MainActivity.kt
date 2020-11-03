package com.example.whatdidilearn.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.example.whatdidilearn.R
import com.example.whatdidilearn.data.DataBaseItens
import com.example.whatdidilearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycleView = binding.itemsRecycleView
        val adapter = LearnedItemsAdapter()
        recycleView.adapter = adapter

        val learnedItemsList = DataBaseItens().getAll()
        adapter.data = learnedItemsList
    }
}