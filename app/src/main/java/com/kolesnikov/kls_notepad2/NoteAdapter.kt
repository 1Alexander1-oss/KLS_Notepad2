package com.kolesnikov.kls_notepad2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kolesnikov.kls_notepad2.entity.Note

class NoteAdapter(
    private val notes: List<Note>,
    private val listener: OnItemClickListener,
) : RecyclerView.Adapter<NoteViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.note_item,
                parent,
                false,
            ),
            listener
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = notes[position]
        holder.setContent(note)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

}

class NoteViewHolder(
    itemView: View,
    private val listener: OnItemClickListener,
) : RecyclerView.ViewHolder(itemView) {
    fun setContent(note: Note) {
        itemView.setOnClickListener {
            listener.onItemClick(note.id)
        }

        val titleView = itemView.findViewById<TextView>(R.id.title)
        val description = itemView.findViewById<TextView>(R.id.description)
        titleView.text = note.title
        description.text = note.description
    }
}