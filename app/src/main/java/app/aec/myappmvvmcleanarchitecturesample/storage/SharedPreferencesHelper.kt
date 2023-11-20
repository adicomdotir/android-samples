package app.aec.myappmvvmcleanarchitecturesample.storage

import android.content.Context
import app.aec.myappmvvmcleanarchitecturesample.displaynotes.Notes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

private const val ADD_NOTES = "add_notes"

class SharedPreferencesHelper @Inject constructor(context: Context) : Storage {
    private val sharedPreferences =
        context.getSharedPreferences("NOTES_STORAGE", Context.MODE_PRIVATE)

    override fun putJsonString(key: String, notes: ArrayList<Notes>) {
        with(sharedPreferences.edit()) {
            val json = Gson().toJson(notes)
            putString(key, json)
            apply()
        }
    }

    override fun getJsonString(key: String?): ArrayList<Notes> {
        val json = sharedPreferences.getString(key, null)
        val type = object : TypeToken<ArrayList<Notes?>?>() {}.type

        return try {
            Gson().fromJson(json, type)
        } catch (e: Exception) {
            ArrayList()
        }
    }
}