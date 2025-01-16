package com.route.islamiapp.splash

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.route.islamiapp.R

class IslamiSplashActivity : AppCompatActivity() {
    // 1- Version Control System (Git)
    // 2- Islamic App

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_islami)
    }

}