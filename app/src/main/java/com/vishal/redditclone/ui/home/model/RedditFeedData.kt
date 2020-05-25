package com.vishal.redditclone.ui.home.model

import com.google.gson.annotations.SerializedName
import com.vishal.redditclone.ui.home.model.Children

class RedditFeedData {
	@SerializedName("children")
	var children: ArrayList<Children>? = null
}