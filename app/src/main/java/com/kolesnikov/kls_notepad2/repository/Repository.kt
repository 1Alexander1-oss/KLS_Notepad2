package com.kolesnikov.kls_notepad2.repository

import android.security.identity.AccessControlProfileId
import com.kolesnikov.kls_notepad2.entity.Note

interface Repository {
    fun addNote(note: Note)
    fun getAllNotes(): ArrayList<Note>
    fun getNote(id: Int): Note?
}