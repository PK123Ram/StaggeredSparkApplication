package com.example.staggeredsparkapplication.dataaccesslayer.response;

public class Root {

    private String uid;
    private String published_at;
    private String description;
    private String thumbnail;
    private Actions action_counts;
    private Expert expert;

    public Root() {
    }

    public Root(String uid, String published_at, String thumbnail, Actions action_counts, Expert expert,String description) {
        this.uid = uid;
        this.published_at = published_at;
        this.thumbnail = thumbnail;
        this.action_counts = action_counts;
        this.expert = expert;
        this.description = description;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Actions getAction_counts() {
        return action_counts;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public void setAction_counts(Actions action_counts) {
        this.action_counts = action_counts;
    }

    public Expert getExpert() {
        return expert;
    }

    public void setExpert(Expert expert) {
        this.expert = expert;
    }
}
