package com.vishal.redditclone.ui.home

import com.google.gson.annotations.SerializedName

class RedditFeedData {
    @SerializedName("children")
    var children: ArrayList<Children>? = null
}