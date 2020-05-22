package com.vishal.redditclone

import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_splash.*


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val w: Window = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        VideoView.setVideoURI(Uri.parse("https://v.redd.it/aculbr22raz41/HLSPlaylist.m3u8?f=sd&v=v1&a=1592739523%2CNDlkZjY5MGMzNTMzNWUyOWNkZWIxYzhiOTM2ODU0MjQ5YzhlNmZmNzQ3NjRkMTIwYTY3ZTZhM2YzZjQ4ZTI2Nw%3D%3D"))
        VideoView.setOnPreparedListener { mp -> mp.isLooping = true }
        VideoView.start()
    }
}
