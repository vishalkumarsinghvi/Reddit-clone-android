package com.vishal.redditclone.ui.post;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vishal.redditclone.R;
import com.vishal.redditclone.databinding.CommentPostListItemBinding;
import com.vishal.redditclone.ui.home.Children;

import java.util.ArrayList;

public class PostDataAdapter extends RecyclerView.Adapter<PostDataAdapter.PostViewHolder> {
    private ArrayList<Children> commentData;

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        CommentPostListItemBinding commentPostListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.comment_post_list_item, viewGroup, false);
        return new PostViewHolder(commentPostListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder PostViewHolder, int i) {
        final Children currentPost = commentData.get(i);
        PostViewHolder.commentPostListItemBinding.setData(currentPost.getData());
//        PostViewHolder.commentPostListItemBinding.cvData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (currentPost.getData() != null && currentPost.getData().getPermalink() != null)
//                    ((HomeActivity) view.getContext()).click(currentPost.getData().getPermalink());
//            }
//        });
    }

    @Override
    public int getItemCount() {
        if (commentData != null) {
            return commentData.size();
        } else {
            return 0;
        }
    }

    public void setCommentList(ArrayList<Children> postData) {
        this.commentData = postData;
        notifyDataSetChanged();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        private CommentPostListItemBinding commentPostListItemBinding;

        public PostViewHolder(@NonNull CommentPostListItemBinding commentPostListItemBinding) {
            super(commentPostListItemBinding.getRoot());
            this.commentPostListItemBinding = commentPostListItemBinding;
        }
    }
}