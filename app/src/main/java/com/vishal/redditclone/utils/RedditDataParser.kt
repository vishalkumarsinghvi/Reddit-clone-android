package com.vishal.redditclone.utils

import com.vishal.redditclone.ui.post.model.RedditContent
import com.vishal.redditclone.ui.post.model.RedditData
import com.vishal.redditclone.ui.post.model.RedditResponse
import rx.Observable
import rx.functions.Func1

class RedditDataParser : Func1<RedditResponse, Observable<RedditContent>> {
	
	var after: String? = null
	
	override fun call(redditResponse: RedditResponse?): Observable<RedditContent> {
		return Observable.just(redditResponse?.data).flatMap { redditData: RedditData? ->
					this.after = redditData?.after
					if (redditData == null) {
						Observable.empty()
					} else {
						Observable.from(redditData.children)
					}
				}
		
	}
}