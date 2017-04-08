package com.example.user.retrofitting.mvp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 2/13/2017.
 */

public class Movie {
    @SerializedName("adult")
    private boolean adult;
    @SerializedName("poster_path")
    private String posterPath;
    @SerializedName("release_date")
    private String releaseDate;
    @SerializedName("original_title")
    private String originalTitle;
    @SerializedName("id")
    private int id;

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    @SerializedName("overview")
    private String overView;

    public Movie(boolean adult, String posterPath, String releaseDate, String originalTitle, int id, String title,String overView) {
        this.adult = adult;
        this.overView=overView;
        this.posterPath = posterPath;
        this.releaseDate = releaseDate;
        this.originalTitle = originalTitle;
        this.id = id;
        this.title = title;
    }

    @SerializedName("title")

    private String title;

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
