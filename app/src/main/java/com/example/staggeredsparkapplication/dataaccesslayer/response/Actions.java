package com.example.staggeredsparkapplication.dataaccesslayer.response;

public class Actions {

    private int like;

    private int click;

    public Actions() {
    }

    public Actions(int like, int click) {
        this.like = like;
        this.click = click;
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
