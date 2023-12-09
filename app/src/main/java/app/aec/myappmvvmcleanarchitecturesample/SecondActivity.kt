package app.aec.myappmvvmcleanarchitecturesample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import app.aec.myappmvvmcleanarchitecturesample.utils.Constants.Companion.MY_TAG
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondActivity : AppCompatActivity() {
    @Inject lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        car.start()
    }
}

class Car @Inject constructor(val engine: Engine) {
    init {
        Log.e(MY_TAG, "Init Car")
    }

    fun start(): Unit {
        Log.e(MY_TAG, "Car Started")
    }
}

class Engine @Inject constructor() {
    init {
        Log.e(MY_TAG, "Init Engine")
    }
}