package com.kolesnikov.kls_notepad2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.kolesnikov.kls_notepad2.database.NoteDBHalper
import com.kolesnikov.kls_notepad2.entity.Note
import com.kolesnikov.kls_notepad2.repository.SqlRepository

class NoteCreatorActivity : AppCompatActivity() {
    private lateinit var title: EditText
    private lateinit var description: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_creator)

        val repository = SqlRepository(dbHalper = NoteDBHalper(this))

        title = findViewById(R.id.title)
        description = findViewById(R.id.description)
        button = findViewById(R.id.save_button)
        button.setOnClickListener {
            val title = this.title.text.toString()
            val description = this.description.text.toString()
            val note = Note(0, title, description)
            repository.addNote(note)
            onBackPressed()

        }
    }
}
// Создание базы даных, как в прошлом проекте