package com.vishal.redditclone.ui.home

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class HomeViewModel : ViewModel() {
	
	var progressView = MutableLiveData<Int>()
	var RedditFeed: MutableLiveData<RedditFeed> = MutableLiveData<RedditFeed>()
	
	
	fun initHomeViewModel() {
		init()
		progressView.value = View.VISIBLE
		HomeRepository.getInstance.getRandomPost()
	}
	
	fun updateUi(): LiveData<RedditFeed?> {
		return RedditFeed
	}
	
	fun init() {
		HomeRepository.getInstance.subscribe().observeForever { t ->
			RedditFeed.value = t
			progressView.setValue(View.GONE)
		}
	}
	
	
}