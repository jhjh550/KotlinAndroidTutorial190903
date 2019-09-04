package com.example.androidtutorial.T10_xml

import android.os.AsyncTask
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_xml.*
import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserFactory
import java.net.URL

class XmlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xml)

        btnXml.setOnClickListener {
            WeatherTask().execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153052000")
        }
    }

    class WeatherTask: AsyncTask<String, Unit, String>(){
        override fun doInBackground(vararg params: String?): String {
            var res = ""
            val path = params[0]!!
            val url = URL(path)
            val factory = XmlPullParserFactory.newInstance()
            val xpp = factory.newPullParser()
            xpp.setInput(url.openStream(), "utf-8")
            var eventType = xpp.eventType
            var bRead = false
            while (eventType != XmlPullParser.END_DOCUMENT){
                if(eventType == XmlPullParser.START_TAG){
                    when(xpp.name){
                        "hour","day","temp","wfKor"->{ bRead = true }
                    }
                }else if(eventType == XmlPullParser.TEXT){
                    if(bRead){
                        res += xpp.text + " "
                        bRead = false
                    }
                }
                eventType = xpp.next()
            }


            return res
        }

    }
}
