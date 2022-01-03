package com.kolesnikov.kls_notepad2.database

import android.provider.BaseColumns

object NoteDB : BaseColumns {
    const val TABLE_NAME = "notes"
    const val COLUMN_NAME_TITLE = "title"
    const val COLUMN_NAME_DESCRIPTION = "description"

    const val DATABASE_VERSION = 1
    const val DATABASE_NAME =
        "Notes.model"

    const val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS $TABLE_NAME (" +
            "${BaseColumns._ID} INTEGER PRIMARY KEY, " +
            "$COLUMN_NAME_TITLE TEXT, " +
            "$COLUMN_NAME_DESCRIPTION TEXT" +
            ")"
    const val SQL_DELETE_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
}


