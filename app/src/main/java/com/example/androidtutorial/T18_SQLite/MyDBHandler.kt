package com.example.androidtutorial.T18_SQLite

import android.content.ContentValues
import android.content.Context

class MyDBHandler(context: Context) {
    val helper: MyOpenHelper = MyOpenHelper(context,
        "people.db", null, 1)

    fun insert(name:String, age:Int, address: String){
        val values = ContentValues()
        values.put("name", name)
        values.put("age", age)
        values.put("address", address)
        helper.writableDatabase.insert("student",
            null, values)
    }

    fun delete(name:String){
        helper.writableDatabase.delete("student",
            "name = ?", arrayOf(name))
    }

    fun update(name:String, newAge:Int){
        val values = ContentValues()
        values.put("age", newAge)
        helper.writableDatabase.update("student", values,
            "name = ?", arrayOf(name))
    }

    fun selectAll():String{

    }

}