package com.example.staggeredsparkapplication.dataaccesslayer.repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.staggeredsparkapplication.dataaccesslayer.response.Result;
import com.example.staggeredsparkapplication.dataaccesslayer.response.Root;
import com.example.staggeredsparkapplication.database.ProfileDatabase;
import com.example.staggeredsparkapplication.database.entity.Post;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MainRepository {
    private ProfileDatabase db;
    private LiveData<List<Post>> getAllPost;

    public MainRepository(Context context) {
        this.db = ProfileDatabase.getInstance(context);
        getAllPost = db.getPostDao().getAllPost();
    }

    public void getAllJsonData(final Context context) {
        ProfileDatabase.service.execute(new Runnable() {
            @Override
            public void run() {
                if (db.getPostDao().getCount() <= 0) {
                    Gson gson = new Gson();
                    Result result = gson.fromJson(loadJSONFromAsset(context), Result.class);

                    for (Root root : result.getResults()) {
                        db.getPostDao().insertPost(new Post(root.getUid(), root.getPublished_at(),
                                root.getThumbnail(), root.getExpert().getName(),
                                root.getExpert().getProfile_pic(),
                                root.getExpert().getShort_bio(), root.getDescription(),
                                root.getAction_counts().getLike(), root.getAction_counts().getClick()));
                    }


                    Log.d("ABCD", "run" + result);

                }
            }
        });


    }

    public String loadJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("NewFile.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public LiveData<List<Post>> getGetAllPost() {
        return getAllPost;
    }

    public void updatePost(final int like, final int click, final String uid) {
        ProfileDatabase.service.execute(new Runnable() {
            @Override
            public void run() {
                db.getPostDao().updatePost(like, click, uid);
            }
        });
    }
}
