package app.aec.myappmvvmcleanarchitecturesample.addnotes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import app.aec.myappmvvmcleanarchitecturesample.addnotes.AddNotesActivity.AddNotesViewState

private const val DATE_MAX_LENGTH = 6
private const val TITLE_MAX_LENGTH = 3

class AddNotesViewModel : ViewModel() {
    private val addNoteStateMutableLiveData = MutableLiveData<AddNotesViewState>()
    val addNoteStateLiveData: LiveData<AddNotesViewState>
        get() = addNoteStateMutableLiveData

    fun validateNotes(date: String, title: String, notes: String) {
        when {
            date.length < DATE_MAX_LENGTH -> addNoteStateMutableLiveData.value =
                AddNotesViewState.AddNotesFailure("Date must not be empty")

            title.length < TITLE_MAX_LENGTH -> addNoteStateMutableLiveData.value =
                AddNotesViewState.AddNotesFailure("Title must not be less than 3 characters")

            notes.length < TITLE_MAX_LENGTH -> addNoteStateMutableLiveData.value =
                AddNotesViewState.AddNotesFailure("Notes must not be less than 3 characters")

            else -> {
                addNoteStateMutableLiveData.value = AddNotesViewState.AddNotesSuccess
            }
        }
    }
}