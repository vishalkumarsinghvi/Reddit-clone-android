package com.vishal.redditclone.apiInterface;

import com.vishal.redditclone.ui.home.RedditFeed;
import com.vishal.redditclone.ui.login.LoginModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiServices {

  @POST("api/login/{user}")
  Call<LoginModel> login(@Path("user") String usernameforPath,
      @Query("user") String username,
      @Query("passwd") String password,
      @Query("api_type") String api_type
  );

  @GET("/r/random/top.json?limit=5")
  Call<RedditFeed> getRandomPost();


}
