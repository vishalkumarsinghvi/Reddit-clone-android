package com.vishal.redditclone.apiInterface

import com.vishal.redditclone.ui.home.model.RedditFeed
import com.vishal.redditclone.ui.login.LoginModel
import com.vishal.redditclone.ui.post.model.RedditResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable

interface ApiServices {
	@POST("api/login/{user}")
	fun login(@Path("user") usernameforPath: String?, @Query("user") username: String?, @Query("passwd") password: String?, @Query("api_type") api_type: String?): Call<LoginModel?>?

	@get:GET("/r/random/top.json?limit=5")
	val randomPost: Call<RedditFeed?>?

	@GET("{url}.json")
	fun getPostWithComment(@Path(value = "url", encoded = true) url: String?): Call<List<RedditFeed?>?>?

	@GET("{permalink}.json")
	fun getPost(@Path(value = "permalink", encoded = true) permalink: String?): Observable<List<RedditResponse?>?>?
}