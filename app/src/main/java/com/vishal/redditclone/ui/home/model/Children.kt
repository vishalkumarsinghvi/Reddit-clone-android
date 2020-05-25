package com.vishal.redditclone.ui.home.model

import com.google.gson.annotations.SerializedName

class Children {
	@SerializedName("data")
	var data: Data? = null
	
	@SerializedName("kind")
	var kind: String? = null
	
	override fun toString(): String {
		return "ClassPojo [data = $data, kind = $kind]"
	}
}