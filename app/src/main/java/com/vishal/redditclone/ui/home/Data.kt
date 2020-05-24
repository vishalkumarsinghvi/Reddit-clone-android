package com.vishal.redditclone.ui.home

import android.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.gson.annotations.SerializedName


class Data {

    @SerializedName("subreddit")
    var subreddit: String? = null

    @SerializedName("thumbnail")
    var thumbnail: String? = null

    @SerializedName("title")
    var title: String? = null

    @SerializedName("permalink")
    var permalink: String? = null

    @SerializedName("body")
    var body: String? = null

    @SerializedName("score")
    var score: String? = null

    @SerializedName("created")
    var created: String? = null

    @SerializedName("downs")
    var downs: String? = null

    @SerializedName("author")
    var author: String? = null

    @SerializedName("name")
    var name: String? = null

    @SerializedName("ups")
    var ups: String? = null

    companion object {
        @JvmStatic
        @BindingAdapter("thumbnail")
        fun loadImage(imageView: ImageView, imageURL: String?) {
            Glide.with(imageView.context)
                .setDefaultRequestOptions(
                    RequestOptions()
                        .circleCrop()
                )
                .load(imageURL)
                .placeholder(R.drawable.ic_menu_info_details)
                .into(imageView)
        }
    }
}