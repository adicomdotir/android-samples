package app.aec.myappmvvmcleanarchitecturesample.displaynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.aec.myappmvvmcleanarchitecturesample.R
import app.aec.myappmvvmcleanarchitecturesample.addnotes.AddNotesActivity
import app.aec.myappmvvmcleanarchitecturesample.addnotes.AddNotesViewModel
import app.aec.myappmvvmcleanarchitecturesample.storage.SharedPreferencesHelper
import app.aec.myappmvvmcleanarchitecturesample.utils.GlobalUtils.notesList
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: MainViewModel
    private var viewManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        val factory = MainViewModelFactory(SharedPreferencesHelper(this))
        viewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            startActivity(Intent(this@MainActivity, AddNotesActivity::class.java))
        }

        callAdapter()
        observeData()
    }

    override fun onStart() {
        super.onStart()
        if (notesList.size > 0) {
            viewModel.addNotes()
        }
    }

    private fun callAdapter() {
        recyclerView.layoutManager = viewManager
    }

    private fun observeData() {
        viewModel.notesLiveData.observe(this) {
            recyclerView.adapter = MainAdapter(viewModel, this)
        }
    }
}