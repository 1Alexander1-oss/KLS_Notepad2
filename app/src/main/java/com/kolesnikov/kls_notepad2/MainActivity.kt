package com.kolesnikov.kls_notepad2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kolesnikov.kls_notepad2.entity.Note

class MainActivity : AppCompatActivity() {
    private lateinit var recycler: RecyclerView
    private val notes = listOf<Note>(
        Note(title = "Учёба", description = "Такое", id = 1),
        Note(title = "Коробки", description = "Ждут", id = 2),
        Note(title = "Новый Год", description = "Как Старый Год", id = 3)

    )
    private val adapter = NoteAdapter(notes)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycler = findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter
    }

}