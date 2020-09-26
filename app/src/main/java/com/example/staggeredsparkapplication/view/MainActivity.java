package com.example.staggeredsparkapplication.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.staggeredsparkapplication.R;
import com.example.staggeredsparkapplication.database.entity.Post;
import com.example.staggeredsparkapplication.databinding.PostBinding;
import com.example.staggeredsparkapplication.viewmodel.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel viewModel;
    PostAdapter adapter;
    private static final int NUM_COLUMNS = 2;
    private PostBinding postBinding;
    private List<Post> listOfPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewModel.parseJsonResponse();
        listOfPost  = new ArrayList<>();
        setUpRecyclerView();
        subscribeObservers();

    }

    public void setUpRecyclerView(){
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(NUM_COLUMNS, LinearLayoutManager.VERTICAL);
        adapter = new PostAdapter(listOfPost,getApplication());
        postBinding.staggeredRecyclerView.setLayoutManager(staggeredGridLayoutManager);
        postBinding.staggeredRecyclerView.setHasFixedSize(true);
        postBinding.staggeredRecyclerView.setAdapter(adapter);
    }

    public void subscribeObservers(){
        viewModel.getGetAllPost().observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> postList) {
                listOfPost.clear();
                listOfPost.addAll(postList);
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}