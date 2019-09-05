package com.example.androidtutorial.T13_RuntimePermission

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import gun0912.tedbottompicker.TedBottomPicker
import kotlinx.android.synthetic.main.activity_permission.*


class PermissionActivity : AppCompatActivity() {

    private val PERMISSION_REQ_CODE = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.androidtutorial.R.layout.activity_permission)

        btnPermission.setOnClickListener {
            val permission = ContextCompat.checkSelfPermission(
                this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            if(permission != PackageManager.PERMISSION_GRANTED){
                setupPermission()
            }else{
                imagePick()
            }
        }
    }

    private fun imagePick(){
        TedBottomPicker.with(this)
            .show {
                myImageView.setImageURI(it)
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
                    .setMessage("Permission to write external storage is required fo this app")
                    .setPositiveButton("OK"){dialogInterface, which ->
                        requestPermission()
                    }.show()
            }else{
                requestPermission()
            }
        }
    }

    private fun requestPermission(){
        ActivityCompat.requestPermissions(this,
            arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE),
            PERMISSION_REQ_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == PERMISSION_REQ_CODE){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                imagePick()
            }else{

            }
        }
    }
}
