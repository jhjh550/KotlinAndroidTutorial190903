package com.example.androidtutorial.T13_RuntimePermission

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.androidtutorial.R
import kotlinx.android.synthetic.main.activity_permission.*


class PermissionActivity : AppCompatActivity() {

    private val PERMISSION_REQ_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_permission)

        btnPermission.setOnClickListener {
            setupPermission()
        }
    }

    private fun setupPermission(){
        val permission = ContextCompat.checkSelfPermission(
            this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        if(permission != PackageManager.PERMISSION_GRANTED){
            if(ActivityCompat.shouldShowRequestPermissionRationale(
                    this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE
                )){
                AlertDialog.Builder(this)
                    .setTitle("Permission requested!!")
                    .setMessage("Permission to write external storage is reuired fo this app")
                    .setPositiveButton("OK"){dialogInterface, which ->
                        ActivityCompat.requestPermissions(this,
                            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
                            PERMISSION_REQ_CODE)
                    }.show()

            }
        }
    }
}
