package app.aec.myappmvvmcleanarchitecturesample.storage

import app.aec.myappmvvmcleanarchitecturesample.displaynotes.Notes

interface Storage {
    fun putJsonString(key: String, notes: ArrayList<Notes>)

    fun getJsonString(key: String?): ArrayList<Notes>
}