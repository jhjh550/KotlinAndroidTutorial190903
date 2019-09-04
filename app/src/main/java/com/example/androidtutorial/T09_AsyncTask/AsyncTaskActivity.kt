package com.example.androidtutorial.T09_AsyncTask

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R

class AsyncTaskActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async_task)
    }

    class MyTask: AsyncTask<Int, Float, String>(){

        override fun onProgressUpdate(vararg values: Float?) {
            super.onProgressUpdate(*values)
        }

        override fun doInBackground(vararg p0: Int?): String {
            for(i in 0..100){
                Thread.sleep(100)
                publishProgress(i.toFloat())
            }
            return "my task done!!!"
        }

    }
}
