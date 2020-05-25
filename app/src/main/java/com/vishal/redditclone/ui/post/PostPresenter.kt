package com.vishal.redditclone.ui.post

import android.util.Log
import com.vishal.redditclone.ui.post.commentPostStore.PostStore
import com.vishal.redditclone.ui.post.model.Comment
import com.vishal.redditclone.utils.CommentParser
import com.vishal.redditclone.utils.RedditDataParser
import rx.Observer
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription


class PostPresenter(internal var view: PostContractor.View, internal var postStore: PostStore) : PostContractor.Presenter {
	
	val compositeSubscription = CompositeSubscription()
	
	override fun start() {
	
	}
	
	override fun unsubscribe() {
		compositeSubscription.clear()
	}
	
	override fun loadInfo(permalink: String) {
		var i: Int = 0
		compositeSubscription.add(postStore.getPost(permalink).subscribeOn(Schedulers.io()).flatMapIterable({ redditResponses -> redditResponses }).flatMap(RedditDataParser()).filter({ redditContent -> redditContent.kind == "t1" && redditContent.redditContentData != null }).map(CommentParser()).observeOn(AndroidSchedulers.mainThread()).subscribe(object : Observer<Comment> {
			override fun onCompleted() {
				Log.e("tag", "completed")
			}
			
			override fun onError(e: Throwable) {
				Log.e("tag", "e " + e.printStackTrace())
			}
			
			override fun onNext(comment: Comment) {
				if (i < 5) {
					view.showComment(comment)
					i++
				}
			}
		}))
	}
}
