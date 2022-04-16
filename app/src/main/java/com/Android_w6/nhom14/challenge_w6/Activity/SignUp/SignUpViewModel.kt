package com.Android_w6.nhom14.challenge_w6

import android.view.View
import androidx.lifecycle.ViewModel


class SignUpViewModel : ViewModel()
{
    var account : Account=Account("","","","")

    fun validateEmail(editemail: String): Boolean{

        var emailPattern = "[a-zA-z0._-]+@[a-z]+\\.+[a-z]+"
        return !(editemail.isEmpty()|| !editemail.matches(Regex(emailPattern)))
    }

    fun validatePassword(editpass: String): Boolean{

        var passwordVal = "(?=.*[0-9])" + "(?=.*[a-z])" + "(?=.*[A-Z])" + "(?=.*[!@#$%^&*()])" + ".{8,}"
        return !(editpass.isEmpty()||!editpass.matches(Regex(passwordVal)))

    }

    fun registerUser(view: View,editpass: String, editemail: String): Boolean {

        return !(!validatePassword(editpass) or !validateEmail(editemail))

    }

}