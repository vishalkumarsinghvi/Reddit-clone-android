package com.vishal.redditclone.ui.home.model

import com.google.gson.annotations.SerializedName


class Data {
	
	@SerializedName("subreddit")
	var subreddit: String? = null
	
	@SerializedName("thumbnail")
	var thumbnail: String? = null
	
	@SerializedName("title")
	var title: String? = null
	
	@SerializedName("permalink")
	var permalink: String? = null
	
	@SerializedName("body")
	var body: String? = null
	
	@SerializedName("score")
	var score: String? = null
	
	@SerializedName("created")
	var created: String? = null
	
	@SerializedName("downs")
	var downs: String? = null
	
	@SerializedName("author")
	var author: String? = null
	
	@SerializedName("name")
	var name: String? = null
	
	@SerializedName("ups")
	var upVotes: String? = null
	
	@SerializedName("subreddit_name_prefixed")
	val subredditNamePrefixed: String? = null
	
	@SerializedName("over_18")
	val isNsfw = false
	
	@SerializedName("created_utc")
	val createdAt: Long = 0
	
	@SerializedName("num_comments")
	val numComments = "0"
	
	@SerializedName("children")
	val children: List<Data>? = null
}