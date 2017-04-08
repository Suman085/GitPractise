package com.example.user.retrofitting.Api;

import com.example.user.retrofitting.mvp.model.MovieDetails;
import com.example.user.retrofitting.mvp.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by User on 2/13/2017.
 */

public interface ApiInterface
{
    @GET("movie/top_rated")
    Observable<MovieResponse> getTopRatedMovies(@Query("api_key")String apiKey);

    @GET("movie/{id}")
    Observable<MovieDetails> getMovieDetails(@Path("id")int id, @Query("api_key")String apiKey);

}
