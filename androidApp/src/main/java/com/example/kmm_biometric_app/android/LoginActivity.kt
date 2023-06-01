package com.example.kmm_biometric_app.android

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.kmm_biometric_app.FaceAuthenticator

class LoginActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val authenticate = findViewById<Button>(R.id.authenticate_button)
        authenticate.setOnClickListener {

            val faceAuthenticatorImpl = FaceAuthenticator(this)
            if (faceAuthenticatorImpl.isDeviceHasBiometric()) {
                faceAuthenticatorImpl.authenticateWithFace {
                    if (it){ Log.d("'LoginActivity.kt'", "Authentication Successful") }
                    else{ Log.d("'LoginActivity.kt'", "Authentication Failed") }
                }
            }
        }
    }
}