package com.vishal.redditclone.ui.post.model

import com.google.gson.annotations.SerializedName

class RedditContent {
	var kind: String? = null
	
	@SerializedName("data")
	var redditContentData: RedditContentData? = null
}