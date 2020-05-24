package com.vishal.redditclone.ui.post

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.vishal.redditclone.R
import com.vishal.redditclone.databinding.ActivityPostBinding

class PostActivity : AppCompatActivity() {
	
	lateinit var binding: ActivityPostBinding
	lateinit var postViewModel: PostViewModel
	lateinit var postDataAdapter: PostDataAdapter
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_post)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_post)
		postViewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory(application)).get(PostViewModel::class.java)
		binding.lifecycleOwner = this
		binding.viewmodel = postViewModel
		postViewModel.initPostViewModel(intent.extras?.get("link").toString())
		val recyclerView: RecyclerView = binding.viewComments
		recyclerView.layoutManager = LinearLayoutManager(this)
		recyclerView.setHasFixedSize(true)
		postDataAdapter = PostDataAdapter()
		recyclerView.adapter = postDataAdapter
		postViewModel.updateUi().observe(this, Observer {
			if (it != null) {
				binding.tvTitle.text = it[0]?.redditFeedData?.children?.get(0)?.data?.title
				binding.tvSubtitle.text = it[0]?.redditFeedData?.children?.get(0)?.data?.subreddit
				val url = it[0]?.redditFeedData?.children?.get(0)?.data?.thumbnail
				Glide.with(this@PostActivity).setDefaultRequestOptions(RequestOptions().circleCrop()).load(url).placeholder(android.R.drawable.ic_menu_info_details).into(binding.ivPic)
				postDataAdapter.setCommentList(it[1]?.redditFeedData?.children)
			} else {
				Toast.makeText(this, "Data null", Toast.LENGTH_SHORT).show()
			}
		})
	}
}
