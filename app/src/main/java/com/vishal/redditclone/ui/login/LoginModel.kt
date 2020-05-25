package com.vishal.redditclone.ui.login

import com.google.gson.annotations.SerializedName

class LoginModel {
	@SerializedName("json")
	var json: Json? = null
	
	override fun toString(): String {
		return "ClassPojo [json = $json]"
	}
}