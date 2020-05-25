package com.vishal.redditclone.ui.post.model;

import com.google.gson.annotations.SerializedName;
import com.vishal.redditclone.ui.home.model.Children;
import java.util.ArrayList;

public class RedditContentData {

  private String id;
  private String title;
  @SerializedName("subreddit_name_prefixed")
  private String subredditNamePrefixed;
  @SerializedName("over_18")
  private boolean isNsfw;
  @SerializedName("created_utc")
  private Long createdAt;
  private String thumbnail;
  private String author;
  private String subreddit;
  @SerializedName("ups")
  private int upVotes;
  private int score;
  @SerializedName("num_comments")
  private int numComments;
  @SerializedName("body")
  private String body;
  private Preview preview;
  private String permalink;
  private RedditResponse replies;

  @SerializedName("children")
  private ArrayList<Children> children;

  public RedditContentData() {
  }

  public ArrayList<Children> getChildren() {
    return children;
  }

  public void setChildren(ArrayList<Children> children) {
    this.children = children;
  }

  public RedditContentData(String id, String title, String subredditNamePrefixed, boolean isNsfw,
      Long createdAt, String thumbnail, String author) {
    this.id = id;
    this.title = title;
    this.subredditNamePrefixed = subredditNamePrefixed;
    this.isNsfw = isNsfw;
    this.createdAt = createdAt;
    this.thumbnail = thumbnail;
    this.author = author;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubredditNamePrefixed() {
    return subredditNamePrefixed;
  }

  public void setSubredditNamePrefixed(String subredditNamePrefixed) {
    this.subredditNamePrefixed = subredditNamePrefixed;
  }

  public boolean isNsfw() {
    return isNsfw;
  }

  public void setNsfw(boolean nsfw) {
    isNsfw = nsfw;
  }

  public Long getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Long createdAt) {
    this.createdAt = createdAt;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getSubreddit() {
    return subreddit;
  }

  public void setSubreddit(String subreddit) {
    this.subreddit = subreddit;
  }

  public int getUpVotes() {
    return upVotes;
  }

  public void setUpVotes(int upVotes) {
    this.upVotes = upVotes;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getNumComments() {
    return numComments;
  }

  public void setNumComments(int numComments) {
    this.numComments = numComments;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Preview getPreview() {
    return preview;
  }

  public void setPreview(Preview preview) {
    this.preview = preview;
  }

  public String getPermalink() {
    return permalink;
  }

  public void setPermalink(String permalink) {
    this.permalink = permalink;
  }

  public RedditResponse getReplies() {
    return replies;
  }

  public void setReplies(RedditResponse replies) {
    this.replies = replies;
  }
}
