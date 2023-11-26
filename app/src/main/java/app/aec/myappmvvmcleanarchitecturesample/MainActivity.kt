package app.aec.myappmvvmcleanarchitecturesample

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import app.aec.myappmvvmcleanarchitecturesample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, MainViewModelFactory(0))[MainViewModel::class.java]

        binding.btnClick.setOnClickListener {
            viewModel.increaseCounter()
        }

        viewModel.counter.observe(this) {
            binding.tvMsg.text = it.toString()
        }
    }
}