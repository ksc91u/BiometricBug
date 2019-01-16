package org.ksc91u.biometricbug

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricPrompt
import androidx.core.app.ActivityCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bioBtn1.setOnClickListener {
            val prompt = BiometricPrompt(
                this@MainActivity,
                ActivityCompat.getMainExecutor(this@MainActivity),
                object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        mainTv.text = "First Success"
                    }
                }
            )

            val promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("First Title")
                .setDescription("First Description")
                .setNegativeButtonText("Cancel")
                .build()
            prompt.authenticate(promptInfo)
        }

        bioBtn2.setOnClickListener {
            val prompt = BiometricPrompt(
                this@MainActivity,
                ActivityCompat.getMainExecutor(this@MainActivity),
                object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                        mainTv.text = "Second Success"
                    }
                }
            )

            val promptInfo = BiometricPrompt.PromptInfo.Builder()
                .setTitle("Second Title")
                .setDescription("Second Description")
                .setNegativeButtonText("Cancel")
                .build()
            prompt.authenticate(promptInfo)
        }
    }
}
