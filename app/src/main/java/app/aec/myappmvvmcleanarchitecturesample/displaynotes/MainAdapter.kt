package app.aec.myappmvvmcleanarchitecturesample.displaynotes

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import app.aec.myappmvvmcleanarchitecturesample.R
import app.aec.myappmvvmcleanarchitecturesample.utils.GlobalUtils.notesList

class MainAdapter(val viewModel: MainViewModel, private val ctx: Context) :
    RecyclerView.Adapter<MainAdapter.NotesViewHolder>() {

    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(notes: Notes): Unit {
            itemView.findViewById<TextView>(R.id.tv_title).text = notes.title
            itemView.findViewById<TextView>(R.id.tv_description).text = notes.description
            itemView.findViewById<TextView>(R.id.tv_date).text = notes.date

            val deleteBtn = itemView.findViewById<ImageView>(R.id.iv_delete)
            deleteBtn.setOnClickListener {
                viewModel.removeNotes(notes)
                notifyItemChanged(notesList.indexOf(notes))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val root = LayoutInflater.from(parent.context).inflate(R.layout.adapter_main, parent, false)
        return NotesViewHolder(root)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(notesList[position])
    }

    override fun getItemCount(): Int {
        if (notesList.size == 0) {
            Toast.makeText(ctx, "List is empty", Toast.LENGTH_SHORT).show()
        }
        return notesList.size
    }

}
