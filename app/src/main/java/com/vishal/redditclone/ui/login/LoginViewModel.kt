package com.vishal.redditclone.ui.login

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class LoginViewModel : ViewModel() {
	
	var progressView = MutableLiveData<Int>()
	var loginModel: MutableLiveData<LoginModel> = MutableLiveData<LoginModel>()
	
	
	fun initLoginViewModel() {
		progressView.value = View.GONE
		init()
	}
	
	fun doLogin(userName: String, password: String) {
		progressView.value = View.VISIBLE
		LoginRepository.getInstance.loginSuccess(userName, password)
	}
	
	
	fun updateUi(): LiveData<LoginModel?> {
		return loginModel
	}
	
	fun init() {
		LoginRepository.getInstance.subscribe().observeForever { t ->
			loginModel.value = t
			progressView.setValue(View.GONE)
		}
	}
	
	
}