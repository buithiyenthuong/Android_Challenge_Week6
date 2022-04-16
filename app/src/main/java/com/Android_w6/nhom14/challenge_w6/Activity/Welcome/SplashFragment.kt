package com.Android_w6.nhom14.challenge_w6.Activity.Welcome

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.Android_w6.nhom14.challenge_w6.Activity.Boarding.Fragment.OnboardingOneFragment
import com.Android_w6.nhom14.challenge_w6.R


class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.splash, container, false)
        return view
    }

    override fun onStart() {
        super.onStart()
        Log.e("Splash", "Splash Activity _ onStart")

        val timer = object : CountDownTimer(3000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                Log.e("Splash", "Splash Activity _ onStart")
            }

            override fun onFinish() {
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<OnboardingOneFragment>(R.id.frag_container_view)
                    addToBackStack(null)

                }
            }
        }
        timer.start()
    }

    override fun onResume() {
        super.onResume()
        Log.e("Splash", "Splash Activity _ onResume")
    }
}