package com.vishal.redditclone.ui.login

import com.google.gson.annotations.SerializedName

class Data {
	@SerializedName("modhash")
	var modhash: String? = null
	
	@SerializedName("cookie")
	var cookie: String? = null
	
	override fun toString(): String {
		return "ClassPojo [modhash = $modhash, cookie = $cookie]"
	}
}