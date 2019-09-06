package com.example.androidtutorial.T23_Style

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_my_style.*

class MyStyleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_style)

        val numberListener = View.OnClickListener {
            val btn = it as Button
            val value = btn.text.toString()
            val working = workingTextView.text
            if(workingTextView.text == "0"){
                workingTextView.text = value
            }else{
                workingTextView.text = "$working$value"
            }
        }
        zeroBtn.setOnClickListener(numberListener)
        oneBtn.setOnClickListener(numberListener)
        enterBtn.setOnClickListener {
            selectedTextView.text = workingTextView.text
            workingTextView.text = "0"
        }
    }
}
