package com.vishal.redditclone.ui.post

import android.R
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vishal.redditclone.ui.home.RedditFeed


class PostViewModel : ViewModel() {
	
	var progressView = MutableLiveData<Int>()
	var thumbnail = MutableLiveData<String>()
	var subreddit = MutableLiveData<String>()
	var title = MutableLiveData<String>()
	var RedditFeed: MutableLiveData<List<RedditFeed?>> = MutableLiveData<List<RedditFeed?>>()
	
	
	fun initPostViewModel(url: String) {
		init()
		progressView.value = View.VISIBLE
		PostRepository.getInstance.getPostWithComment(url)
	}
	
	fun updateUi(): LiveData<List<RedditFeed?>> {
//		title.value = RedditFeed.value?.get(0)?.redditFeedData?.children?.get(0)?.data?.title
//		subreddit.value = RedditFeed.value?.get(0)?.redditFeedData?.children?.get(0)?.data?.subreddit
//		thumbnail.value = RedditFeed.value?.get(0)?.redditFeedData?.children?.get(0)?.data?.thumbnail
		return RedditFeed
	}
	
	fun init() {
		PostRepository.getInstance.subscribe().observeForever { t ->
			RedditFeed.value = t
			progressView.setValue(View.GONE)
		}
	}
	
//	companion object {
//		@JvmStatic
//		@BindingAdapter("thumbnail")
//		fun loadImage(imageView: ImageView, imageURL: String?) {
//			Glide.with(imageView.context).setDefaultRequestOptions(RequestOptions().circleCrop()).load(imageURL).placeholder(R.drawable.ic_menu_info_details).into(imageView)
//		}
//	}
	
	
}