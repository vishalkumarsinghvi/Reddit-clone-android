package com.vishal.redditclone.ui.post.commentPostStore;

import androidx.annotation.NonNull;
import com.nytimes.android.external.store.base.Fetcher;
import com.nytimes.android.external.store.base.impl.BarCode;
import com.nytimes.android.external.store.base.impl.Store;
import com.nytimes.android.external.store.base.impl.StoreBuilder;
import com.vishal.redditclone.apiInterface.ApiServices;
import com.vishal.redditclone.ui.post.model.RedditResponse;
import java.util.List;
import javax.annotation.Nonnull;
import rx.Observable;

public class PostStore implements PostStoreDataSource {

  private ApiServices apiServices;

  private Store<List<RedditResponse>, BarCode> store;
  private Fetcher<List<RedditResponse>, BarCode> fetcher = new Fetcher<List<RedditResponse>, BarCode>() {
    @NonNull
    @Override
    public Observable<List<RedditResponse>> fetch(@Nonnull BarCode barCode) {
      return getRemotePost(barCode.getKey());
    }
  };

  public PostStore(ApiServices apiServices) {
    this.apiServices = apiServices;
    this.store = StoreBuilder.<List<RedditResponse>>barcode()
        .fetcher(fetcher)
        .open();
  }

  private Observable<List<RedditResponse>> getRemotePost(String key) {
    return apiServices.getPost(key);
  }

  @Override
  public Observable<List<RedditResponse>> getPost(String permalink) {
    BarCode barCode = new BarCode("Post", permalink);
    return store.get(barCode);
  }

}
