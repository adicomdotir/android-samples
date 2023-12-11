package app.aec.myappmvvmcleanarchitecturesample

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.Locale

val coroutineExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
    println("${getReadableDate()}, Error message -> ${throwable.message}")
}

fun main(args: Array<String>) {
    readablePrint("main")

    val job = GlobalScope.launch(Dispatchers.IO + coroutineExceptionHandler) {
        val resultPosts = async { requestPosts() }
        val resultDb = async { saveInDb() }
        resultPosts.await()
        resultDb.await()
        updateUi()
    }

    runBlocking {
        job.join()
    }

    readablePrint("main")
}

suspend fun updateUi() {
    throw Exception("custom exception")
    readablePrint("updateUi")
    delay(1000)
}

suspend fun saveInDb() {
    readablePrint("saveInDb")
    delay(1000)
}

suspend fun requestPosts() {
    readablePrint("requestPosts")
    delay(2000)
}

fun readablePrint(methodName: String) {
    println("${getReadableDate()}, $methodName, Thread Name -> ${Thread.currentThread().name}")
}

fun getReadableDate(): String {
    val simpleDateFormat = SimpleDateFormat("HH:mm:ss:SSS", Locale.ENGLISH)
    val stamp = Timestamp(System.currentTimeMillis())
    return simpleDateFormat.format(stamp)
}