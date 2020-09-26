package com.example.staggeredsparkapplication.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.staggeredsparkapplication.database.entity.Post;

import java.util.List;

@Dao
public interface PostDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPost(Post post);

    @Query("update post_table set `like`= :like , `click` = :click where `uid` =:uid")
    void  updatePost(int like, int click, String uid);

    @Query("select * from post_table")
    LiveData<List<Post>> getAllPost();

    @Query(" select count(*) from post_table ")
    int getCount();
}
