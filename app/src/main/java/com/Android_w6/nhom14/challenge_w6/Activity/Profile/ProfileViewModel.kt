package com.Android_w6.nhom14.challenge_w6


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel: ViewModel() {

    var account : MutableLiveData<Account> = MutableLiveData()
    fun setFullName(fullname : String)
    {
        account.value?.fullname=fullname
        account.postValue(account.value)
    }
    fun setEmail(email : String)
    {
        account.value?.email=email
        account.postValue(account.value)
    }
    fun setPhone(phone : String)
    {
        account.value?.phone=phone
        account.postValue(account.value)
    }
    fun setPass(pass : String)
    {
        account.value?.password=pass
        account.postValue((account.value))
    }

}