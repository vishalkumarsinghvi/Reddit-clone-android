package com.vishal.redditclone.ui.post.commentPostStore;

import com.vishal.redditclone.ui.post.model.RedditResponse;
import java.util.List;
import rx.Observable;

public interface PostStoreDataSource {

  Observable<List<RedditResponse>> getPost(String permalink);

}
