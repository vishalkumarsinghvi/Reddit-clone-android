package com.vishal.redditclone.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.vishal.redditclone.R;
import com.vishal.redditclone.databinding.PostListItemBinding;

import java.util.ArrayList;

public class HomeDataAdapter extends RecyclerView.Adapter<HomeDataAdapter.PostViewHolder> {
    private ArrayList<Children> postData;

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        PostListItemBinding postListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.post_list_item, viewGroup, false);
        return new PostViewHolder(postListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder PostViewHolder, int i) {
        final Children currentPost = postData.get(i);
        PostViewHolder.postListItemBinding.setData(currentPost.getData());
        PostViewHolder.postListItemBinding.cvData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentPost.getData() != null && currentPost.getData().getPermalink() != null)
                    ((HomeActivity) view.getContext()).click(currentPost.getData().getPermalink());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (postData != null) {
            return postData.size();
        } else {
            return 0;
        }
    }

    public void setPostList(ArrayList<Children> postData) {
        this.postData = postData;
        notifyDataSetChanged();
    }

    class PostViewHolder extends RecyclerView.ViewHolder {
        private PostListItemBinding postListItemBinding;

        public PostViewHolder(@NonNull PostListItemBinding postListItemBinding) {
            super(postListItemBinding.getRoot());
            this.postListItemBinding = postListItemBinding;
        }
    }
}