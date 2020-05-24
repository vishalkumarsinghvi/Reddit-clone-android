package com.vishal.redditclone.ui.home

import com.google.gson.annotations.SerializedName

class RedditFeed {
    @SerializedName("data")
    var redditFeedData: RedditFeedData? = null
}