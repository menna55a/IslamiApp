package com.route.islamiapp.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.route.islamiapp.R
import com.route.islamiapp.home.HomeActivity

class IslamiSplashActivity : AppCompatActivity() {
    // 1- Version Control System (Git)
    // 2- Islamic App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_islami)
        Handler(Looper.getMainLooper()).postDelayed(
            {
                navigationScreen()
            },2000)

    }

    private fun navigationScreen(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}