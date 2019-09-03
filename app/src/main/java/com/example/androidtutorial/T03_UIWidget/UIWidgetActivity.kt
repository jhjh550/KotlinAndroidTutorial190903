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
            val myText = editTextHello.text.toString()
            Toast.makeText(this, myText, Toast.LENGTH_SHORT).show()
            editTextHello.setText("")
        }
        myCheckBox.setOnCheckedChangeListener { compoundButton, checked ->
            Toast.makeText(this, "checked $checked", Toast.LENGTH_SHORT).show()
        }
        radioGroup.setOnCheckedChangeListener { radioGroup, id ->
            when(id){
                R.id.radio1->{Toast.makeText(this, "radio1", Toast.LENGTH_SHORT).show()}
                R.id.radio2->{Toast.makeText(this, "radio2", Toast.LENGTH_SHORT).show()}
                R.id.radio3->{Toast.makeText(this, "radio3", Toast.LENGTH_SHORT).show()}
            }
        }
    }
}
