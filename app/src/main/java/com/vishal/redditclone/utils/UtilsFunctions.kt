package com.vishal.redditclone.utils

import android.content.Context
import android.widget.Toast
import com.vishal.redditclone.utils.AppConstants.MY_PREFS_NAME

class UtilsFunctions(private val context: Context) {
	fun setLoginToken(modhash: String?, cookie: String?) {
		val editor = context.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE).edit()
		editor.putString("modhash", modhash)
		editor.putString("cookie", cookie)
		editor.commit()
	}
	
	val loginModhash: String?
		get() {
			val prefs = context.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE)
			return prefs.getString("modhash", null)
		}
	
	fun showToast(value: String) {
		Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
	}
	
	
}