package com.vishal.redditclone.ui.post.model

import com.google.gson.annotations.SerializedName

class RedditData {
	var modhash: String? = null
	
	@SerializedName("children")
	var children: List<RedditContent>? = null
	var after: String? = null
	var before: String? = null
	
}