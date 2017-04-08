package com.example.user.retrofitting.mvp.view;

import com.example.user.retrofitting.mvp.model.Movie;

import java.util.List;

/**
 * Created by User on 3/28/2017.
 */

public interface MainView {
    void onResonseRecieved(List<Movie> movies);
}
