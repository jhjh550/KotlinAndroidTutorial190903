package com.example.androidtutorial.T03_UIWidget

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_uiwidget.*

class UIWidgetActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uiwidget)

        btnHello.setOnClickListener {
            Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
        }
        myCheckBox.setOnCheckedChangeListener { compoundButton, checked ->
            Toast.makeText(this, "checked $checked", Toast.LENGTH_SHORT).show()
        }
    }
}
