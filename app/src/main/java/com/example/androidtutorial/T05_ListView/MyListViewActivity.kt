package com.example.androidtutorial.T05_ListView

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_my_list_view.*

class MyListViewActivity : AppCompatActivity() {

    val myData = arrayOf("hello", "world", "android", "kotlin",
        "hello", "world", "android", "kotlin",
        "hello", "world", "android", "kotlin",
        "hello", "world", "android", "kotlin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_list_view)

        val adapter = ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, myData)
        myListView.adapter = adapter

        myListView.setOnItemClickListener { adapterView, view, position, id ->
            val str = myData[position]
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
        }
    }
}
