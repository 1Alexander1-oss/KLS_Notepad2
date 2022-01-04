package com.kolesnikov.kls_notepad2.repository

import android.content.ContentValues
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
import com.kolesnikov.kls_notepad2.database.NoteDB
import com.kolesnikov.kls_notepad2.database.NoteDBHalper
import com.kolesnikov.kls_notepad2.entity.Note

class SqlRepository(dbHalper: NoteDBHalper) : Repository {
    private val database: SQLiteDatabase? = dbHalper.writableDatabase
    private lateinit var contentValues: ContentValues

    override fun addNote(note: Note) {
        val title = note.title
        val description = note.description
        contentValues = ContentValues()
        contentValues.put(NoteDB.COLUMN_NAME_TITLE, title)
        contentValues.put(NoteDB.COLUMN_NAME_DESCRIPTION, description)

        database?.insert(NoteDB.TABLE_NAME, null, contentValues)
    }

    override fun getAllNotes(): ArrayList<Note> {
        val notes: ArrayList<Note> = arrayListOf()
        val cursor: Cursor? =
            database?.query(
                NoteDB.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
            )

        cursor ?: return arrayListOf()

        while (cursor.moveToNext()) {
            var title = ""
            var description = ""
            var id = 1
            val titleIndex = cursor.getColumnIndex(NoteDB.COLUMN_NAME_TITLE)

            if (titleIndex >= 0) {
                title = cursor.getString(titleIndex)
            }
            val descriptionIndex = cursor.getColumnIndex(NoteDB.COLUMN_NAME_DESCRIPTION)

            if (descriptionIndex >= 0) {
                description = cursor.getString(descriptionIndex)
            }
            val idIndex = cursor.getColumnIndex(BaseColumns._ID)
            if (idIndex >= 0) {
                id = cursor.getInt(idIndex)
            }
            val note = Note(id, title, description)
            notes.add(note)
        }
        cursor.close()
        return notes
    }

    override fun getNote(id: Int): Note? {
        val selectQuery = "SELECT * FROM ${NoteDB.TABLE_NAME} WHERE ${BaseColumns._ID} = ?"
        val cursor: Cursor? =
            database?.rawQuery(selectQuery, arrayOf("$id")).apply {
                this ?: return null
                if (moveToFirst()){
                    return Note(
                        getInt(getColumnIndex(BaseColumns._ID) ?: 0),
                        getString(getColumnIndex(NoteDB.COLUMN_NAME_TITLE) ?: 0),
                        getString(getColumnIndex(NoteDB.COLUMN_NAME_DESCRIPTION) ?: 0)
                    )
                }
            }.also { it?.close() }

        return null
    }
}
// вывести на экран - доделать!
// 3) При нажатии на кнопку "удалить"Ю использовать ранее полученный id для запроса удаления Note из Базы Данных


