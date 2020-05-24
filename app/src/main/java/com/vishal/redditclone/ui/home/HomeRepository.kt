package com.vishal.redditclone.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vishal.redditclone.apiInterface.ApiServices
import com.vishal.redditclone.network.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepository {
	
	private val apiServices: ApiServices = RetrofitInstance.createService(ApiServices::class.java)
	val redditData = MutableLiveData<RedditFeed?>()
	fun getRandomPost(): MutableLiveData<RedditFeed?> {
		apiServices.randomPost.enqueue(object : Callback<RedditFeed?> {
			override fun onResponse(call: Call<RedditFeed?>, response: Response<RedditFeed?>) {
				if (response.isSuccessful) {
					redditData.value = (response.body())
				}
			}
			
			override fun onFailure(call: Call<RedditFeed?>, t: Throwable) {
				redditData.value = (null)
			}
		})
		return redditData
	}
	
	fun subscribe(): LiveData<RedditFeed?> {
		return redditData
	}
	
	
	companion object {
		private var homeRepository: HomeRepository? = null
		val getInstance: HomeRepository
			get() {
				if (homeRepository == null) {
					homeRepository = HomeRepository()
				}
				return homeRepository!!
			}
	}
	
}