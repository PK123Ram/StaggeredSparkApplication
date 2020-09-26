package com.example.staggeredsparkapplication.viewmodel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.staggeredsparkapplication.dataaccesslayer.repository.MainRepository;
import com.example.staggeredsparkapplication.dataaccesslayer.response.Actions;
import com.example.staggeredsparkapplication.dataaccesslayer.response.Expert;
import com.example.staggeredsparkapplication.dataaccesslayer.response.Root;
import com.example.staggeredsparkapplication.database.entity.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MainRepository repository;
    private Context context;
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        context= application.getApplicationContext();
        repository = new MainRepository(application.getApplicationContext());
    }

    public LiveData<List<Post>> getGetAllPost() {
        return repository.getGetAllPost();
    }

    public void updatePost(int like, int click, String uid){
        repository.updatePost(like,click,uid);
    }

    public void parseJsonResponse() {
        repository.getAllJsonData(context);
    }
}
