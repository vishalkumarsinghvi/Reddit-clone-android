package com.vishal.redditclone.ui.post

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.vishal.redditclone.R
import com.vishal.redditclone.apiInterface.ApiServices
import com.vishal.redditclone.databinding.ActivityPostBinding
import com.vishal.redditclone.network.RetrofitInstance
import com.vishal.redditclone.ui.post.commentPostStore.PostStore
import com.vishal.redditclone.ui.post.model.Comment
import com.vishal.redditclone.utils.UtilsFunctions
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder

class PostActivity : AppCompatActivity(), PostContractor.View {
	
	lateinit var binding: ActivityPostBinding
	private val groupAdapter = GroupAdapter<ViewHolder>()
	private lateinit var groupLayoutManager: GridLayoutManager
	lateinit var postStore: PostStore
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_post)
		binding = DataBindingUtil.setContentView(this, R.layout.activity_post)
		postStore = PostStore(RetrofitInstance.createService(ApiServices::class.java))
		setPresenter(PostPresenter(this, postStore))
		groupLayoutManager = GridLayoutManager(this, groupAdapter.spanCount).apply {
			spanSizeLookup = groupAdapter.spanSizeLookup
		}
		
		binding.viewComments.apply {
			layoutManager = groupLayoutManager
			adapter = groupAdapter
		}
		
		groupLayoutManager = GridLayoutManager(this, groupAdapter.spanCount).apply {
			spanSizeLookup = groupAdapter.spanSizeLookup
		}
		
		binding.viewComments.apply {
			layoutManager = groupLayoutManager
			adapter = groupAdapter
		}
		UtilsFunctions(this).showToast("Long Press to show more comments")
		
	}
	
	override fun showComment(comment: Comment) {
		groupAdapter.add(ExpandableCommentGroup(comment))
		binding.progressBar.visibility = View.GONE
	}
	
	override fun setPresenter(presenter: PostContractor.Presenter) {
		val permalink = intent.extras?.get("link").toString()
		presenter.loadInfo(permalink)
	}
}
