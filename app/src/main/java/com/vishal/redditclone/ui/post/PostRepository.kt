package com.vishal.redditclone.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vishal.redditclone.apiInterface.ApiServices
import com.vishal.redditclone.network.RetrofitInstance
import com.vishal.redditclone.ui.home.RedditFeed
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.net.URLDecoder

class PostRepository {
	
	private val apiServices: ApiServices = RetrofitInstance.createService(ApiServices::class.java)
	val redditData = MutableLiveData<List<RedditFeed?>>()
	fun getPostWithComment(url: String): MutableLiveData<List<RedditFeed?>> {
		apiServices.getPostWithComment(url).enqueue(object : Callback<List<RedditFeed?>> {
			override fun onResponse(call: Call<List<RedditFeed?>>, response: Response<List<RedditFeed?>>) {
				if (response.isSuccessful) {
					redditData.value = (response.body())
				}
			}
			
			override fun onFailure(call: Call<List<RedditFeed?>>, t: Throwable) {
				redditData.value = (null)
			}
		})
		return redditData
	}
	
	fun subscribe(): LiveData<List<RedditFeed?>?> {
		return redditData
	}
	
	
	companion object {
		private var postRepository: PostRepository? = null
		val getInstance: PostRepository
			get() {
				if (postRepository == null) {
					postRepository = PostRepository()
				}
				return postRepository!!
			}
	}
	
}