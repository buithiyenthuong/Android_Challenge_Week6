package com.Android_w6.nhom14.challenge_w6.Activity.Boarding.Fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.Android_w6.nhom14.challenge_w6.R

class OnboardingOneFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.onboard, container, false)
        view.setOnTouchListener(object: View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent): Boolean {
                if (event.action == MotionEvent.ACTION_MOVE) {
                    parentFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace<OnboardingTwoFragment>(R.id.frag_container_view)
                        addToBackStack(null)

                    }
                }
                return true
            }
        })


        return view
    }

    override fun onStart() {
        super.onStart()
        Log.e("OnboardingtwoActivity", "Onboardingtwo Activity _ onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.e("OnboardingtwoActivity", "Onboardingtwo Activity _ onResume")
    }
}