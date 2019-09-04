package com.example.androidtutorial.T07_AlertDialog

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R

class DialogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        val builder = AlertDialog.Builder(this)
        builder
            .setTitle("hello title")
            .setMessage("hello message")
            .setPositiveButton("OK") { dialog, which ->
                Toast.makeText(this, "positive button clicked",
                    Toast.LENGTH_SHORT).show()
            }
        builder.show()
    }
}
