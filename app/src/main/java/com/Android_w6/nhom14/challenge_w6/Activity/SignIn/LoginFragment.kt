package com.Android_w6.nhom14.challenge_w6.Activity.SignIn

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.lifecycle.ViewModelProvider
import com.Android_w6.nhom14.challenge_w6.*
import com.Android_w6.nhom14.challenge_w6.Activity.Movie.ListMovieActivity
import com.Android_w6.nhom14.challenge_w6.Activity.SignUp.SignUpFragment
import com.Android_w6.nhom14.challenge_w6.databinding.LoginBinding
import kotlinx.android.synthetic.main.login.*

class LoginFragment:Fragment() {
    private lateinit var binding : LoginBinding
    private lateinit var viewModel: LoginViewModel
    private var account : Account = Account("Default fullname", "default email", "Default password", "000000000")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.login,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding.account = viewModel.account
        binding.apply {
            btn_login.setOnClickListener {
                var check_login : Int =viewModel.checkLogin(binding)
                if(check_login!=-1)
                {
                    val intent = Intent(context,ListMovieActivity::class.java)
                    startActivity(intent)
                }else
                {
                    Toast.makeText(context, "Please try again", Toast.LENGTH_SHORT).show()
                }
                invalidateAll()

            }
            btn_signup.setOnClickListener{
                parentFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<SignUpFragment>(R.id.frag_container_view)
                    addToBackStack(null)
                }
            }
        }
    }
    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }
}