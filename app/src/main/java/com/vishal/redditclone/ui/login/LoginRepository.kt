package com.vishal.redditclone.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vishal.redditclone.apiInterface.ApiServices
import com.vishal.redditclone.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {
	
	private val apiServices: ApiServices = RetrofitInstance.createService(ApiServices::class.java)
	val loginData = MutableLiveData<LoginModel?>()
	fun loginSuccess(username: String?, password: String?): MutableLiveData<LoginModel?> {
		apiServices.login(username, username, password, "json")?.enqueue(object : Callback<LoginModel?> {
			override fun onResponse(call: Call<LoginModel?>, response: Response<LoginModel?>) {
				if (response.isSuccessful) {
					loginData.value = (response.body())
				}
			}
			
			override fun onFailure(call: Call<LoginModel?>, t: Throwable) {
				loginData.value = (null)
			}
		})
		return loginData
	}
	
	fun subscribe(): LiveData<LoginModel?> {
		return loginData
	}
	
	
	companion object {
		private var loginRepository: LoginRepository? = null
		val getInstance: LoginRepository
			get() {
				if (loginRepository == null) {
					loginRepository = LoginRepository()
				}
				return loginRepository!!
			}
	}
	
}