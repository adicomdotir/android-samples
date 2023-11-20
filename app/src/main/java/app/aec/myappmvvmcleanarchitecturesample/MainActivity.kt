package app.aec.myappmvvmcleanarchitecturesample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var job: Job
    private var counter = 0
    private val maxCount = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart = findViewById<Button>(R.id.btn_start)
        val btnCancel = findViewById<Button>(R.id.btn_cancel)

        val job1 = GlobalScope.launch(start = CoroutineStart.LAZY) {
            delay(200)
            Log.d("TAG", "Pong")
            delay(200)
        }

        GlobalScope.launch {
            delay(200)
            Log.d("TAG", "Ping")
            job1.join()
            Log.d("TAG", "Ping")
            delay(200)
        }

        btnStart.setOnClickListener {
            if (!::job.isInitialized) {
                createJob()
            }
        }

        btnCancel.setOnClickListener {
            if (::job.isInitialized) {
                job.cancel()
            }
        }

//        CoroutineScope(Main).launch {
//            stuff1()
//            stuff1()
//            stuff1()
//        }
//
//        CoroutineScope(Main).launch {
//            runBlocking {
//                stuff2()
//                delay(8000)
//            }
//        }
    }

    suspend fun fetchDataFromApi(): String {
        delay(2000) // تقلیل اجباری برای شبیه‌سازی عملیات بلوک‌کننده
        return "نتیجه عملیات شبکه"
    }

    suspend fun processData(data: String): String {
        delay(1000) // تقلیل اجباری برای شبیه‌سازی عملیات بلوک‌کننده
        return "داده پردازی شده: $data"
    }

    private suspend fun stuff1() {
        Log.d("TAG", "1")
        delay(1000)
    }

    private suspend fun stuff2() {
        Log.d("TAG", "2")
        delay(1000)
    }

    private suspend fun doWork() {
        Log.d("TAG", "doWork with 1 second delay")
        delay(1000)
    }

    private fun createJob() {
        job = Job()
        job.invokeOnCompletion {
            it?.message.let { msg ->
                if (msg != null)
                    toast(msg)
            }
        }
        counter(job)
    }

    private fun counter(job: Job) {
        if (counter < maxCount) {
            CoroutineScope(IO + job).launch {
                Log.e("TAG", this.toString())
                counter++
                updateTextView()
                delay(1000)
                createJob()
            }
        }
    }

    private fun updateTextView() {
        CoroutineScope(Main).launch {
            val textView = findViewById<TextView>(R.id.tv_date)
            textView.text = counter.toString()
        }
    }

    private fun toast(msg: String) {
        GlobalScope.launch(Main) {
            Toast.makeText(
                this@MainActivity,
                msg, Toast.LENGTH_SHORT
            ).show()
        }
    }
}