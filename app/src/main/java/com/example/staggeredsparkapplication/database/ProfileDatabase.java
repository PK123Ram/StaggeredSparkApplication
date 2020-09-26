package com.example.staggeredsparkapplication.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.staggeredsparkapplication.database.dao.PostDao;
import com.example.staggeredsparkapplication.database.entity.Post;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Post.class}, version =2 , exportSchema = false)
public abstract class ProfileDatabase extends RoomDatabase {
    public abstract PostDao getPostDao();
    private static volatile ProfileDatabase Instance;
    public static ExecutorService service = Executors.newFixedThreadPool(5);

    public static ProfileDatabase getInstance(Context context){
        if(Instance==null){
            synchronized (ProfileDatabase.class){
                if(Instance==null){
                    Instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            ProfileDatabase.class,
                            "profile_database"
                    ).fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return Instance;
    }
}
