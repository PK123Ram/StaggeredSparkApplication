package com.example.staggeredsparkapplication.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "post_table")
public class Post {

    @PrimaryKey
    @NonNull
    private String uid;

    @ColumnInfo(name = "published_at")
    private String publishedDate;

    @ColumnInfo(name = "thumbnail")
    private String thumbnail;

    @ColumnInfo(name = "name")
    private String expertName;

    @ColumnInfo(name = "profile_pic")
    private String prifilePic;

    @ColumnInfo(name = "short_bio")
    private String shortBio;

    @ColumnInfo(name = "description")
    private String description;

    @ColumnInfo(name = "like")
    private int like;

    @ColumnInfo(name = "click")
    private int click;

    public Post() {
    }

    public Post(String uid, String publishedDate, String thumbnail, String expertName, String prifilePic, String shortBio, String description, int like, int click) {
        this.uid = uid;
        this.publishedDate = publishedDate;
        this.thumbnail = thumbnail;
        this.expertName = expertName;
        this.prifilePic = prifilePic;
        this.shortBio = shortBio;
        this.description = description;
        this.like = like;
        this.click = click;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getExpertName() {
        return expertName;
    }

    public void setExpertName(String expertName) {
        this.expertName = expertName;
    }

    public String getPrifilePic() {
        return prifilePic;
    }

    public void setPrifilePic(String prifilePic) {
        this.prifilePic = prifilePic;
    }

    public String getShortBio() {
        return shortBio;
    }

    public void setShortBio(String shortBio) {
        this.shortBio = shortBio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }
}
