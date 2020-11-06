package com.example.whatdidilearn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.whatdidilearn.data.DataBaseItems
import com.example.whatdidilearn.databinding.ActivityMainBinding
import com.example.whatdidilearn.databinding.ActivityNewItemBinding
import com.example.whatdidilearn.repository.LearnedItemsRepository
import com.example.whatdidilearn.viewModel.NewLearnedItemViewModel
import com.example.whatdidilearn.viewModel.NewLearnedItemViewModelFactory
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

class NewLearnedItem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityNewItemBinding.inflate(layoutInflater)

         setContentView(binding.root)

        supportActionBar?.title="New Learned Item"

        val dao = DataBaseItems.getDatabase(this, CoroutineScope(Dispatchers.IO)).learnedItemDao()
        val repository = LearnedItemsRepository(dao)
        val viewModelFactory = NewLearnedItemViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(NewLearnedItemViewModel::class.java)

        binding.buttonSalvar.setOnClickListener {
            val title = binding.editTextTitle.text.toString()
            val description = binding.editTextDescription.text.toString()

            viewModel.insertNewLearnedItem(title, description)

            navigateToMainActivity()
        }
    }
    private fun navigateToMainActivity(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}