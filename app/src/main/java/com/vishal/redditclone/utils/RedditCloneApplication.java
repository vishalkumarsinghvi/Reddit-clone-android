package com.vishal.redditclone.utils;

import android.app.Application;

public class RedditCloneApplication extends Application {
    private static RedditCloneApplication instance;

    public static RedditCloneApplication getAppInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
