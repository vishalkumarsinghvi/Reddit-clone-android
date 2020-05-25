package com.vishal.redditclone.network

import com.readystatesoftware.chuck.ChuckInterceptor
import com.vishal.redditclone.network.GsonManager.Companion.instance
import com.vishal.redditclone.utils.RedditCloneApplication
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
	private const val base_url = "https://www.reddit.com/"
	private val retrofit = Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create(instance.gson)).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).client(OkHttpClient.Builder().addInterceptor(ChuckInterceptor(RedditCloneApplication.appInstance)).build()).build()
	fun <S> createService(serviceClass: Class<S>?): S {
		return retrofit.create(serviceClass)
	}
}