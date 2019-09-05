package com.example.androidtutorial.T14_JSON

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import com.google.gson.Gson
import org.json.JSONArray

data class User(val name:String, val tel:String, val age:Int)

class JsonActivity : AppCompatActivity() {

    val str = "[{'name':'kim', 'tel':'010-1111-2222', 'age':11}," +
            "{'name':'park', 'tel':'010-2222-3333', 'age':22}," +
            "{'name':'lee','tel':'010-3333-4444', 'age':33}]"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_json)
        //jsonParsing()
        jsonParsingGson()
    }

    private fun jsonParsingGson(){
        val myList = Gson().fromJson(str, Array<User>::class.java)
        for(obj in myList){
            Log.d("gson", obj.toString())
        }
    }

    private fun jsonParsing(){
        val myList = ArrayList<User>()
        val array = JSONArray(str)
        for(i in 0 until array.length()) {
            val obj = array.getJSONObject(i)
            val name = obj.getString("name")
            val tel = obj.getString("tel")
            val age = obj.getInt("age")
            myList.add(User(name, tel, age))
        }
        for(obj in myList){
            Log.d("json", obj.toString())
        }
    }
}
