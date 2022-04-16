package com.Android_w6.nhom14.challenge_w6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.Android_w6.nhom14.challenge_w6.Activity.Profile.DialogEdit
import com.Android_w6.nhom14.challenge_w6.databinding.ProfileBinding
import kotlinx.android.synthetic.main.profile.*

class ProfileActivity : AppCompatActivity() {
    private  lateinit var binding: ProfileBinding
    private var account : Account = Account("", "", "", "")
    private lateinit var viewModel: ProfileViewModel
    private var idUser: Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.profile)
        viewModel = ViewModelProvider(this).get(ProfileViewModel::class.java)
        viewModel.account.value = account
        Log.e("Profile", "Profile Activity _ onCreate")
        val bundle = intent.extras
        bundle?.let {
            val userInformation = bundle.getParcelable<UserInformationData>("userInformation")
            idUser = userInformation?.index
            viewModel.setFullName(DataStore.getListAccount()[idUser!!].fullname)
            viewModel.setEmail(DataStore.getListAccount()[idUser!!].email)
            viewModel.setPhone(DataStore.getListAccount()[idUser!!].phone)
            viewModel.setPass(DataStore.getListAccount()[idUser!!].password)
        }
        binding.apply {
            val dialogprofile = DialogEdit(this@ProfileActivity)
            dialogprofile.DialogProfileF( txt_Fullname_Profile, "Name",binding,viewModel)
            dialogprofile.DialogProfileF( txt_Phonenumber,"Phone Number",binding,viewModel)
            dialogprofile.DialogProfileF( txt_Email_profile,"Email",binding,viewModel)
        }
        binding.account = viewModel.account.value
        DataStore.getListAccount()[idUser!!]= viewModel.account.value!!
    }
}




