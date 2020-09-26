package com.example.staggeredsparkapplication.view;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.staggeredsparkapplication.R;
import com.example.staggeredsparkapplication.database.entity.Post;
import com.example.staggeredsparkapplication.databinding.SparkDataItemBinding;
import com.example.staggeredsparkapplication.viewmodel.MainActivityViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.StaggeredHolder> {

    public List<Post> listOfPost;
    private MainActivityViewModel viewModel;
    public PostAdapter(List<Post> listOfPost, Application context) {
        this.listOfPost = listOfPost;
        viewModel = new MainActivityViewModel(context);
    }

    @NonNull
    @Override
    public StaggeredHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        SparkDataItemBinding itemBinding = DataBindingUtil.inflate(inflater, R.layout.data_item, parent, false);
        return new StaggeredHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull final StaggeredHolder holder, int position) {
        holder.bind(listOfPost.get(holder.getAdapterPosition()));
        Picasso.get().load(listOfPost.get(position).getThumbnail()).into(holder.itemBinding.img1);
        Picasso.get().load(listOfPost.get(position).getPrifilePic()).into(holder.itemBinding.profileImg);
        if(holder.itemBinding.getPost().getClick()==1){
            holder.itemBinding.likedImg.setVisibility(View.VISIBLE);
            holder.itemBinding.unlikedImg.setVisibility(View.GONE);
        }else{
            holder.itemBinding.unlikedImg.setVisibility(View.VISIBLE);
            holder.itemBinding.likedImg.setVisibility(View.GONE);
        }
        holder.itemBinding.unlikedImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.itemBinding.likedImg.setVisibility(View.VISIBLE);
                holder.itemBinding.unlikedImg.setVisibility(View.GONE);
                int like = holder.itemBinding.getPost().getLike();
                int click = 1;
                String uid = holder.itemBinding.getPost().getUid();
                viewModel.updatePost(like+1,click,uid);

            }
        });
        holder.itemBinding.likedImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.itemBinding.unlikedImg.setVisibility(View.VISIBLE);
                holder.itemBinding.likedImg.setVisibility(View.GONE);
                int like = holder.itemBinding.getPost().getLike();
                int click = 0;
                String uid = holder.itemBinding.getPost().getUid();
                viewModel.updatePost(like-1,click,uid);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfPost.size();
    }

    public static class StaggeredHolder extends RecyclerView.ViewHolder{

        SparkDataItemBinding itemBinding;
        public StaggeredHolder(@NonNull SparkDataItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding=itemBinding;
        }

        public void bind(Post post){
            itemBinding.setPost(post);
        }
    }
}
