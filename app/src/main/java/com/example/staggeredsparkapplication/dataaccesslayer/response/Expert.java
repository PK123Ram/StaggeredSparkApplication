package com.example.staggeredsparkapplication.dataaccesslayer.response;

public class Expert {

    private String name;
    private String profile_pic;
    private String short_bio;

    public Expert() {
    }

    public Expert(String name, String profile_pic, String short_bio) {
        this.name = name;
        this.profile_pic = profile_pic;
        this.short_bio = short_bio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public String getShort_bio() {
        return short_bio;
    }

    public void setShort_bio(String short_bio) {
        this.short_bio = short_bio;
    }

}
