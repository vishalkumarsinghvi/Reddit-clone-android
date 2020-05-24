package com.vishal.redditclone.ui.splash

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.vishal.redditclone.R
import com.vishal.redditclone.ui.home.HomeActivity
import com.vishal.redditclone.ui.login.LoginActivity
import com.vishal.redditclone.utils.AppConstants.splash_video_url
import com.vishal.redditclone.utils.UtilsFunctions
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_splash)
		val w: Window = window
		w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
		VideoView.setVideoURI(Uri.parse(splash_video_url))
		VideoView.setOnPreparedListener { mp -> mp.isLooping = true }
		VideoView.start()
		btn_login.setOnClickListener {
			startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
			finish()
		}
		if (UtilsFunctions(this).loginModhash != null) {
			startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
			finish()
		}
	}
}
