package com.vishal.redditclone.utils

import android.app.Application

class RedditCloneApplication : Application() {
	override fun onCreate() {
		appInstance = this
		super.onCreate()
	}

	companion object {
		var appInstance: RedditCloneApplication? = null
			private set
	}
}