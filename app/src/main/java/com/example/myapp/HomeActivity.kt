package com.example.myapp
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapp.network.MarsApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapp.network.MarsPhoto
import kotlinx.coroutines.Dispatchers
import android.widget.ImageView
import com.example.myapp.databinding.ActivityHomeBinding
import coil.load
import android.widget.TextView
import androidx.databinding.DataBindingUtil

class HomeActivity : AppCompatActivity(){
    var TAG = HomeActivity::class.java.simpleName    //"HomeActivity"

//    lateinit var marsRecyclerView:RecyclerView
    lateinit var marsAdapter: MarsAdapter
    lateinit var photos:List<MarsPhoto>
//    lateinit var imageView: ImageView
    private lateinit var binding: ActivityHomeBinding
    val photoMarsDatabinding = MarsPhoto("007","moonimage.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
//        setContentView(R.layout.activity_home)
//        imageView = findViewById(R.id.imageView)
//        marsRecyclerView = findViewById(R.id.recyclerViewUrls)
//        marsRecyclerView.layoutManager = LinearLayoutManager(this)
        // setContentView(R.layout.activity_home)
        val binding: ActivityHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        /* var homeTextView:TextView = findViewById(R.id.tvHome)
         homeTextView.setText(photoMarsDatabinding.imgSrc)*/
        binding.marsphotoxml = photoMarsDatabinding

        // imageView = findViewById(R.id.imageView)
        // marsRecyclerView = findViewById(R.id.recyclerViewUrls)
        binding.recyclerViewUrls.layoutManager = LinearLayoutManager(this)
        photos = ArrayList()
        marsAdapter = MarsAdapter(photos)
//        marsRecyclerView.adapter = marsAdapter
        binding.recyclerViewUrls.adapter = marsAdapter

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getMarsPhotos() {
        GlobalScope.launch(Dispatchers.Main) {
            //launching coroutines on the main thread is not advisable
            var listMarsPhotos =   MarsApi.retrofitService.getPhotos()
            // photos = listMarsPhotos
            marsAdapter.listMarsPhotos = listMarsPhotos
            //import coil.load
            marsAdapter.notifyDataSetChanged()
//            var tvHome:TextView = findViewById(R.id.tvHome)
//            tvHome.setText(listMarsPhotos.get(1).imgSrc)
            Log.i("homeactivity-url",listMarsPhotos.get(1).imgSrc)

        }
    }

    fun getJson(view: View) {
        getMarsPhotos()
    }

}