package com.example.myapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.database.Item
import com.example.myapp.database.ItemDao
import com.example.myapp.database.ItemRoomDatabase
import com.example.myapp.databinding.ActivityDbBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.launch
import androidx.lifecycle.ViewModelProvider

class DBActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDbBinding
    lateinit var dao: ItemDao
    lateinit var viewModel: DBViewModel

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDbBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var  database = ItemRoomDatabase.getDatabase(this)
        dao = database.itemDao()

        viewModel = ViewModelProvider(this)[DBViewModel::class.java]

        binding.tvHome.setText("" + count)

        binding.btnDbInsert.setOnClickListener{
            insertDataDb()
        }
        binding.btnFind.setOnClickListener{
            findItemDb(21)
        }
        binding.btnInc.setOnClickListener{
            count++
            //viewModel.incrementCount()
            binding.tvHome.setText("" + count)
            //+viewModel.count)
        }
    }
    fun add(a:Int,b:Int):Int{
        return a+b
    }

    private fun insertDataDb() {
        GlobalScope.launch {
            var item = Item(21,"fruits",11.11,11)
            dao.insert(item)
        }
    }
    private fun findItemDb(id: Int) {
        GlobalScope.launch(Dispatchers.Main) {
            var item = dao.getItem(id).first()
            binding.tvHome.setText(item.itemName)
        }
    }
}