package com.example.androidtutorial.T10_xml

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_xml.*

class XmlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml)

        btnXml.setOnClickListener {
            WeatherTask().execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153052000")
        }
    }

    class WeatherTask: AsyncTask<String, Unit, String>(){
        override fun doInBackground(vararg p0: String?): String {
            var res = ""
            //
            return res
        }

    }
}
