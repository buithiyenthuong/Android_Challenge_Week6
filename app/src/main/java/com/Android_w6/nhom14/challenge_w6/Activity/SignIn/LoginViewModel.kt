package com.Android_w6.nhom14.challenge_w6

import androidx.lifecycle.ViewModel
import com.Android_w6.nhom14.challenge_w6.databinding.LoginBinding

class LoginViewModel : ViewModel(){
    var account : Account = Account("default fullname", "", "default password","")
    fun checkLogin(binding:LoginBinding):Int{
        var email=binding.etEmailLogin.text.toString()
        var pass=binding.etPassLogin.text.toString()
        var indexTemp : Int =0
        for(item in DataStore.getListAccount())
        {
            if(email==item.email&&pass==item.password)
            {
                return indexTemp
            }
            indexTemp++
        }
        return -1
    }
}