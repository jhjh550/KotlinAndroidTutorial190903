package com.example.androidtutorial.T04_Activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_my_activity.*

class MyActivity : AppCompatActivity() {

    //private static final int REQ_CODE = 100
    private val REQ_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_activity)

        btnStart.setOnClickListener {
            val intent = Intent(this, NewActivity::class.java)
            intent.putExtra("hello", 123)
//            startActivity(intent)
            startActivityForResult(intent, REQ_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQ_CODE){
            if(resultCode == Activity.RESULT_OK){
                data?.run {
                    val str = getStringExtra("resValue")
                    Toast.makeText(this@MyActivity, str, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
