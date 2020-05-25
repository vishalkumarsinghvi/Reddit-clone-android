package com.vishal.redditclone.ui.post

interface BaseView<T> {
	fun setPresenter(presenter: T)
}