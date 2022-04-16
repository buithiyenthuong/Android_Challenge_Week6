package com.Android_w6.nhom14.challenge_w6


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.Android_w6.nhom14.challenge_w6.Activity.Welcome.SplashFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("Splash", "Splash Activity _ onCreate")
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<SplashFragment>(R.id.frag_container_view)
        }
    }

}