package com.example.androidtutorial.T19_Service

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)

        btnServiceStart.setOnClickListener {
            val intent = Intent(this,
                MyService::class.java)
            startService(intent)
        }
        btnServiceStop.setOnClickListener {
            val intent = Intent(this,
                MyService::class.java)
            stopService(intent)
        }
        btnRandomNumber.setOnClickListener {
            val rand = myBindService?.getRandomNumber()
            Toast.makeText(this, "$rand", Toast.LENGTH_SHORT).show()
        }
    }

    var myBindService: MyBindTypeService? = null
    val conn = object: ServiceConnection{
        override fun onServiceDisconnected(p0: ComponentName?) {
            myBindService = null
        }

        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            val binder = p1 as MyBindTypeService.MyBinder
            myBindService = binder.getService()
        }

    }

    override fun onStart() {
        super.onStart()
        val intent = Intent(this, MyBindTypeService::class.java)
        bindService(intent, conn, Context.BIND_AUTO_CREATE)
    }

    override fun onStop() {
        super.onStop()
        unbindService(conn)
    }


}
