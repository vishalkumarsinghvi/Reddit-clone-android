package com.vishal.redditclone.network;

import com.readystatesoftware.chuck.ChuckInterceptor;
import com.vishal.redditclone.utils.RedditCloneApplication;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static String base_url = "https://www.reddit.com/";

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(new OkHttpClient.Builder()
                    .addInterceptor(new ChuckInterceptor(RedditCloneApplication.getAppInstance()))
                    .build())
            .build();

    public static <S> S createService(Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }
}
