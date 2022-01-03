package com.kolesnikov.kls_notepad2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kolesnikov.kls_notepad2.database.NoteDBHalper
import com.kolesnikov.kls_notepad2.entity.Note
import com.kolesnikov.kls_notepad2.repository.Repository
import com.kolesnikov.kls_notepad2.repository.SqlRepository

class MainActivity : AppCompatActivity() {
    private lateinit var button: FloatingActionButton
    private lateinit var recycler: RecyclerView
    private lateinit var repository: Repository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository = SqlRepository(dbHalper = NoteDBHalper(this))
        recycler = findViewById(R.id.recycler)
        recycler.layoutManager = LinearLayoutManager(this)
        button = findViewById(R.id.floatingActionButton)
        button.setOnClickListener {
            val intent = Intent (this,NoteCreatorActivity::class.java)
            startActivityForResult(intent, 0)
        }
        getNotes()
    }

    private fun getNotes(){
        val notes = repository.getAllNotes()
        val adapter = NoteAdapter(notes)
        recycler.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        getNotes()
        super.onActivityResult(requestCode, resultCode, data)
    }
}