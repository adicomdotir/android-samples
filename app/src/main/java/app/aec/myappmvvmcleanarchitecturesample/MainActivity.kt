package app.aec.myappmvvmcleanarchitecturesample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import app.aec.myappmvvmcleanarchitecturesample.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCount.setOnClickListener {
            binding.tvCount.text = count++.toString()
        }

        val postsMutableLiveData = MutableLiveData<Posts>()
        val service = RetrofitInstance.getService()
        CoroutineScope(Dispatchers.IO).launch {
            val response = service?.getPosts()?.body()
            postsMutableLiveData.postValue(response!!)
//            response?.forEach {
//                Log.e("TAG", it.title)
//            }
        }

        binding.btnDownloadUserData.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val response = service?.getPostsById(1)?.body()
                Log.e("TAG", response.toString())
            }
        }

        postsMutableLiveData.observe(this) {
            Log.e("TAG", it.toString())
        }
    }

    private fun downloadUserData() {
        for (i in 1..200000) {
            Log.i("MyTag", "Downloading user $i in ${Thread.currentThread().name}")
        }
    }
}