package com.example.androidtutorial.T18_SQLite

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R

class SQLiteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)

        val myDBHandler = MyDBHandler(this)
        myDBHandler.insert("kim", 10, "seoul")
        myDBHandler.insert("가나다", 11, "seoul")
        myDBHandler.insert("hello", 12, "seoul")
        myDBHandler.insert("world", 13, "seoul")
        myDBHandler.insert("android", 14, "인천")
        myDBHandler.insert("kotlin", 15, "부산")

        myDBHandler.delete("hello")
        myDBHandler.update("kim", 20)

        val res = myDBHandler.selectAll()
        Log.d("db", res)

    }
}
