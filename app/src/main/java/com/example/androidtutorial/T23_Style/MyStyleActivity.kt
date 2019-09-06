package com.example.androidtutorial.T23_Style

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
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

        var number = 1
        for(i in 2 until rootLayout.childCount - 1){
            val row = rootLayout.getChildAt(i) as LinearLayout
            for(k in 0 until row.childCount){
                val btn = row.getChildAt(k) as Button
                btn.text = "$number"
                number += 1
                btn.setOnClickListener(numberListener)
            }
        }
        val index = rootLayout.childCount - 1
        val lastRow = rootLayout.getChildAt(index) as LinearLayout
        val zeroBtn = lastRow.getChildAt(1) as Button
        zeroBtn.text = "0"
        zeroBtn.setOnClickListener(numberListener)

        val enterBtn = lastRow.getChildAt(2) as Button
        enterBtn.text = "enter"
        enterBtn.setOnClickListener {
            selectedTextView.text = workingTextView.text
            workingTextView.text = "0"
        }

        val deleteBtn = lastRow.getChildAt(0) as Button
        deleteBtn.text = "delete"
        deleteBtn.setOnClickListener {
            workingTextView.text = "0"
        }

    }
}
