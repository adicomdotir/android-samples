package app.aec.myappmvvmcleanarchitecturesample.displaynotes

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.aec.myappmvvmcleanarchitecturesample.storage.Storage
import app.aec.myappmvvmcleanarchitecturesample.utils.GlobalUtils.notesList
import javax.inject.Inject

private const val ADD_NOTES = "add_notes"

class MainViewModel @Inject constructor (private val storage: Storage) : ViewModel() {


    private var notesMutableLiveData = MutableLiveData<ArrayList<Notes>>()
    val notesLiveData: LiveData<ArrayList<Notes>>
        get() = notesMutableLiveData

    init {
        checkStorage()
    }

    private fun checkStorage() {
        val result = storage.getJsonString(ADD_NOTES)
        Log.e("TAG", result.toString())
        if (result.isNotEmpty()) {
            notesList = result
            notesMutableLiveData.value = notesList
        }
    }

    fun addNotes() {
        storage.putJsonString(ADD_NOTES, notesList)
        notesMutableLiveData.value = notesList
    }

    fun removeNotes(notes: Notes) {
        notesList.remove(notes)
        storage.putJsonString(ADD_NOTES, notesList)
        notesMutableLiveData.value = notesList
    }
}