package com.vishal.redditclone.ui.home.model

import com.google.gson.annotations.SerializedName

class RedditFeed {
	var kind: String? = null
	
	@SerializedName("data")
	var redditFeedData: RedditFeedData? = null
}