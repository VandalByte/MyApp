package com.example.myapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

class HomeActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var dataArray = arrayOf("india","hindi","australia","peacock","blue")
    lateinit var myRecycler: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.row_layout_item)
        myRecycler = findViewById(R.id.recyclerView)
        myRecycler.layoutManager = LinearLayoutManager(this)
        var wordsAdapter = WordsAdapter(dataArray)
        myRecycler.adapter = wordsAdapter
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        TODO("Not yet implemented")
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}