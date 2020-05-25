package com.vishal.redditclone.utils

import com.vishal.redditclone.ui.post.model.Comment
import com.vishal.redditclone.ui.post.model.RedditContent
import rx.Observable
import rx.functions.Func1


class CommentParser : Func1<RedditContent, Comment> {
	
	override fun call(redditData: RedditContent): Comment {
		val redditContentData = redditData.redditContentData
		var commentList = emptyList<Comment>()
		if (redditContentData?.replies != null) {
			val commentObservable = Observable.just(redditContentData.replies).flatMap(RedditDataParser()).filter({ redditContent -> redditContent.kind == "t1" && redditContent.redditContentData != null }).map(CommentParser()).toList()
			commentList = commentObservable.toBlocking().first()
		}
		return Comment(redditContentData!!.body, redditContentData.author, redditContentData.score, redditContentData.id, commentList)
	}
	
}