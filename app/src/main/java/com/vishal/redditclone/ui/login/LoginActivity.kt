package com.vishal.redditclone.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vishal.redditclone.R
import com.vishal.redditclone.databinding.ActivityLoginBinding
import com.vishal.redditclone.ui.home.HomeActivity
import com.vishal.redditclone.utils.UtilsFunctions


class LoginActivity : AppCompatActivity() {
	lateinit var binding: ActivityLoginBinding
	lateinit var loginViewModel: LoginViewModel
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
		loginViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(LoginViewModel::class.java)
		binding.lifecycleOwner = this
		binding.viewmodel = loginViewModel
		loginViewModel.initLoginViewModel()
		loginViewModel.updateUi().observe(this, Observer {
			if (it != null) {
				UtilsFunctions(this).setLoginToken(it.json?.data?.modhash, it.json?.data?.cookie)
				startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
				finish()
			} else {
				Toast.makeText(this, "Data null", LENGTH_SHORT).show()
			}
		})
		
		
	}
}
