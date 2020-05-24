package com.vishal.redditclone.ui.post

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.vishal.redditclone.R
import kotlinx.android.synthetic.main.activity_post.*

class PostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)
        textView.text = intent.extras?.get("link").toString()
    }
}
