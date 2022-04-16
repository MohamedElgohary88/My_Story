package com.example.mystory

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        moveToLoginScreen()
    }

    private fun moveToLoginScreen() {
        // هذا الكود خاص بتاخير عملية تسجيل الدخول لعدة ثوانى
        Handler(Looper.myLooper()!!).postDelayed({
            // هذه الدالة تستخدم لحذف الواجهة splash من الذاكرة لكى عند الرجوع لا نرج اليها
            finish()
            val i = Intent(this,LoginActivity::class.java)
            startActivity(i)
        },2000)
    }
}