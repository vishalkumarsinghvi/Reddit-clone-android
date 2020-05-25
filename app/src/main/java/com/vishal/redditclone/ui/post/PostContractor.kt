package com.vishal.redditclone.ui.post

import com.vishal.redditclone.ui.post.model.Comment


interface PostContractor {
	
	interface View : BaseView<Presenter> {
		
		fun showComment(comment: Comment)
	}
	
	interface Presenter : BasePresenter {
		
		fun loadInfo(permalink: String)
		
	}
	
}
