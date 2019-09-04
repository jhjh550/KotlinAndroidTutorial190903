package com.example.androidtutorial.T05_ListView

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R

class MyListViewActivity : AppCompatActivity() {

    val myData = arrayOf("hello", "world", "android", "kotlin",
        "hello", "world", "android", "kotlin",
        "hello", "world", "android", "kotlin",
        "hello", "world", "android", "kotlin")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_list_view)
    }
}
