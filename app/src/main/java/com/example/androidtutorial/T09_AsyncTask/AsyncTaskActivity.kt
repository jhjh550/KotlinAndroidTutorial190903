package com.example.androidtutorial.T09_AsyncTask

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_async_task.*

class AsyncTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)
        btnStart.setOnClickListener {
            val task = MyTask()
            task.execute(30)
        }
    }

    inner class MyTask: AsyncTask<Int, Float, String>(){

        override fun onProgressUpdate(vararg values: Float?) {
            super.onProgressUpdate(*values)
            btnStart.setText("count ${values[0]}")
        }

        override fun doInBackground(vararg params: Int?): String {
            val start = params[0] ?: 0
            for(i in start..100){
                Thread.sleep(100)
                publishProgress(i.toFloat())
            }
            return "my task done!!!"
        }

    }
}
