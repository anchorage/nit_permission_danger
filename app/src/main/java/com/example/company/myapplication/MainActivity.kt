package com.example.company.myapplication

import android.Manifest
import android.app.Application
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)
        var textView = findViewById<TextView>(R.id.textView)
        button.setOnClickListener {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CAMERA), 1)



        }





    }
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            1 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    var textView = findViewById<TextView>(R.id.textView)
                    textView.text = "Granted"
                } else {
                    var textView = findViewById<TextView>(R.id.textView)
                    textView.text = "Denied"
                }
                return
            }
            else -> {
                // id запроса не совпадает с ожидаемым, игнорируем
            }
        }
    }

}
