package com.example.androidtutorial.T04_Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)
    }
}
