package app.aec.myappmvvmcleanarchitecturesample.addnotes

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import app.aec.myappmvvmcleanarchitecturesample.R
import java.time.LocalDate

class AddNotesActivity : AppCompatActivity() {

    private lateinit var addNotesViewModel: AddNotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_notes)

        val actionBar = supportActionBar
        actionBar?.title = "Add Notes"

        addNotesViewModel = ViewModelProvider(this)[AddNotesViewModel::class.java]

        val date = findViewById<TextView>(R.id.tv_date)
        val title = findViewById<TextView>(R.id.edt_title)
        val notes = findViewById<TextView>(R.id.edt_description)
        val submit = findViewById<Button>(R.id.btn_submit)

        date.text = LocalDate.now().toString()

        submit.setOnClickListener {
            addNotesViewModel.validateNotes(
                date.text.toString(),
                title.text.toString(),
                notes.text.toString()
            )
        }

        addNotesViewModel.addNoteStateLiveData.observe(this) { state ->
            when (state) {
                is AddNotesViewState.AddNotesSuccess -> {
                    finish()
                }

                is AddNotesViewState.AddNotesFailure -> {
                    Toast.makeText(this, state.error, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    sealed class AddNotesViewState {
        object AddNotesSuccess : AddNotesViewState()
        data class AddNotesFailure(val error: String) : AddNotesViewState()
    }
}
