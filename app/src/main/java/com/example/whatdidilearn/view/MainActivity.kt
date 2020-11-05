package com.example.whatdidilearn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.whatdidilearn.R
import com.example.whatdidilearn.data.DataBaseItems
import com.example.whatdidilearn.databinding.ActivityMainBinding
import com.example.whatdidilearn.viewModel.LearnedItemViewModel
import com.example.whatdidilearn.viewModel.LearnedItemViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycleView = binding.itemsRecycleView
        val adapter = LearnedItemsAdapter()
        recycleView.adapter = adapter

        val database = DataBaseItems.getDatabase(this, CoroutineScope(Dispatchers.IO))
        val dao = database.learnedItemDao()
        val viewModelFactory = LearnedItemViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(LearnedItemViewModel::class.java)
        val itemsList = viewModel.learnedItemsList
        itemsList.observe(this, Observer { items ->
            adapter.data = items
        })

        val buttonFab = binding.fab
        buttonFab.setOnClickListener {
            var intent = Intent(this, NewLearnedItem::class.java)

            startActivity(intent)
        }
    }
}