package com.example.androidtutorial.T19_Service

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        btnServiceStart.setOnClickListener {
            val intent = Intent(this,
                MyService::class.java)
            startService(intent)
        }
        btnServiceStop.setOnClickListener {
            val intent = Intent(this,
                MyService::class.java)
            stopService(intent)
        }
    }
}
