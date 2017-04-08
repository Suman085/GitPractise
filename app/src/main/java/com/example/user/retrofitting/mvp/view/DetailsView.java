package com.example.user.retrofitting.mvp.view;

import com.example.user.retrofitting.mvp.model.MovieDetails;

/**
 * Created by User on 3/28/2017.
 */
public interface DetailsView {
    void onResponse(MovieDetails movieDetails);
}
