package com.example.androidtutorial.T18_SQLite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyOpenHelper(
    context: Context?,
    name: String?,
    factory: SQLiteDatabase.CursorFactory?,
    version: Int
) : SQLiteOpenHelper(context, name, factory, version) {

    override fun onCreate(db: SQLiteDatabase?) {
        val sql =
            "CREATE TABLE student (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "name TEXT, age INTEGER, address TEXT)"
        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        val sql = "DROP TABLE IF EXISTS student"
        db?.execSQL(sql)
        onCreate(db)
    }
}