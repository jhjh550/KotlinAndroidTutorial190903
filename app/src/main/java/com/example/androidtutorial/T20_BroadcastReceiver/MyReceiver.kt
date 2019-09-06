package com.example.androidtutorial.T20_BroadcastReceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if(intent.action.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            Toast.makeText(
                context, "hello airplane  mode",
                Toast.LENGTH_SHORT
            ).show()
        }else if(intent.action.equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(
                context, "power connected",
                Toast.LENGTH_SHORT
            ).show()
        }else if (intent.action.equals("hello.world.android.kotlin")){

        }
    }
}
