package com.kolesnikov.kls_notepad2.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class NoteDBHalper(context: Context) : SQLiteOpenHelper(
    context, NoteDB.DATABASE_NAME,
    null, NoteDB.DATABASE_VERSION
) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(NoteDB.CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL(NoteDB.SQL_DELETE_TABLE)
        onCreate(db)
    }


}