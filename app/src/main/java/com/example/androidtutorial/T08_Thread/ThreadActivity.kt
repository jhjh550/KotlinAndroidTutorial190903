package com.example.androidtutorial.T08_Thread

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {

    private val MY_COUNT = 100

    val handler = object: Handler(){
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            if(msg.what == MY_COUNT){
                btnStart.setText("count ${msg.arg1}")
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        btnStart.setOnClickListener {
            Thread{
                for(i in 0..100){
                    Log.d("thread", "count ${i}")
                    Thread.sleep(100)
                    val msg = handler.obtainMessage()
                    msg.what = MY_COUNT
                    msg.arg1 = i
                    handler.sendMessage(msg)
                }
            }.start()
        }


    }
}
