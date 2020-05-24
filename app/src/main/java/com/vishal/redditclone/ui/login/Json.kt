package com.vishal.redditclone.ui.login

import com.google.gson.annotations.SerializedName

class Json {
    @SerializedName("data")
    var data: Data? = null

    @SerializedName("errors")
    lateinit var errors: Array<String>

    override fun toString(): String {
        return "ClassPojo [data = $data, errors = $errors]"
    }
}