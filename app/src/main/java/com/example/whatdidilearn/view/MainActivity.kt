package com.example.whatdidilearn.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.whatdidilearn.R
import com.example.whatdidilearn.data.DataBaseItems
import com.example.whatdidilearn.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recycleView = binding.itemsRecycleView
        val adapter = LearnedItemsAdapter()
        recycleView.adapter = adapter

        val learnedItemsList = DataBaseItems.getAll()
        adapter.data = learnedItemsList
//-------------------------------------------------------------------------------
      //  val buttonFab = findViewById<Button>(R.id.fab)
      //  buttonFab.setOnClickListener {
      //      var intent = Intent(this, NewLearnedItem::class.java)

      //      startActivity(intent)
      //  }
//--------------------------------------------------------------------------------
    }
}