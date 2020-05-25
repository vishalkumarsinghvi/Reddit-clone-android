package com.vishal.redditclone.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vishal.redditclone.ui.post.model.RedditContentData

class GsonManager private constructor() {
	val gson: Gson

	companion object {
		val instance = GsonManager()
	}

	init {
		val gsonBuilder = GsonBuilder()
		gsonBuilder.registerTypeAdapter(RedditContentData::class.java, RedditContentDataParser())
		gson = gsonBuilder.create()
	}
}