package com.kolesnikov.kls_notepad2.repository

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.kolesnikov.kls_notepad2.R

class NoteDeleteActivity : AppCompatActivity() {
    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_delete)

        title = findViewById(R.id.title)
        description = findViewById(R.id.description)
        button = findViewById(R.id.delete_button)
        button.setOnClickListener {
            
        }



    }
}