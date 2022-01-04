package com.kolesnikov.kls_notepad2.repository

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.kolesnikov.kls_notepad2.R
import com.kolesnikov.kls_notepad2.database.NoteDB
import com.kolesnikov.kls_notepad2.database.NoteDBHalper

class NoteDeleteActivity : AppCompatActivity() {
    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var button: Button
    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_delete)

        val id = intent.getIntExtra("Key", 0)

        repository = SqlRepository(dbHalper = NoteDBHalper(this))
        title = findViewById(R.id.title)
        description = findViewById(R.id.description)
        button = findViewById(R.id.delete_button)
        button.setOnClickListener {

        }

        val note = repository.getNote(id = id)
        println(note)
    }
}