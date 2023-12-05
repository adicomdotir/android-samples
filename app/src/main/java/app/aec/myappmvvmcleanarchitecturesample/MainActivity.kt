package app.aec.myappmvvmcleanarchitecturesample

import android.app.NotificationManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import app.aec.myappmvvmcleanarchitecturesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val channelID = "ir.adicom.app.channel1"
    private var notificationManager: NotificationManager? = null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}