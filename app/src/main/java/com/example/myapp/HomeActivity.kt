package com.example.myapp
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
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
import okhttp3.Dispatcher

class HomeActivity : AppCompatActivity(){
    var TAG = HomeActivity::class.java.simpleName    //"HomeActivity"

    lateinit var marsRecyclerView:RecyclerView
    lateinit var marsAdapter: MarsAdapter
    lateinit var photos:List<MarsPhoto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        marsRecyclerView = findViewById(R.id.recyclerViewUrls)
        marsRecyclerView.layoutManager = LinearLayoutManager(this)
        photos = ArrayList()
        marsAdapter = MarsAdapter(photos)
        marsRecyclerView.adapter = marsAdapter


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
            photos = listMarsPhotos
            // photos = listMarsPhotos
            marsAdapter.listMarsPhotos = listMarsPhotos
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