package app.aec.myappmvvmcleanarchitecturesample

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import app.aec.myappmvvmcleanarchitecturesample.data.datasources.CustomApi
import app.aec.myappmvvmcleanarchitecturesample.databinding.ActivityMainBinding
import app.aec.myappmvvmcleanarchitecturesample.ui.users_list.UserListViewModel
import app.aec.myappmvvmcleanarchitecturesample.utils.Constants.Companion.MY_TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  val viewModel: UserListViewModel by viewModels()
    @Inject
    lateinit var api: CustomApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenCreated {
            val users = api.getAllUsers()
            Log.e(MY_TAG, users.size.toString())
        }

        binding.btnDownloadUserData.setOnClickListener {
            viewModel.getUsers()
        }

        binding.btnCount.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        CoroutineScope(Dispatchers.Main).launch {
            viewModel.usersValue.collect {
                if (it.isLoading) {
                    binding.progressBar.visibility = View.VISIBLE
                } else {
                    binding.progressBar.visibility = View.INVISIBLE
                }
            }
        }
    }
}