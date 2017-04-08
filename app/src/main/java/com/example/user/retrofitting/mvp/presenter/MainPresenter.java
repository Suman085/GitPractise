package com.example.user.retrofitting.mvp.presenter;

import com.example.user.retrofitting.Api.ApiInterface;
import com.example.user.retrofitting.mvp.model.Movie;
import com.example.user.retrofitting.mvp.model.MovieResponse;
import com.example.user.retrofitting.mvp.view.MainView;
import com.example.user.retrofitting.ui.activities.MainActivity;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by User on 3/28/2017.
 */

public class MainPresenter implements IMainPresenter, rx.Observer<MovieResponse> {
    @Inject
    ApiInterface mApiService;
    @Inject
    MainView mMainView;

    @Inject
    public MainPresenter() {
    }

    public void getResponse() {
        Observable<MovieResponse> getMovieResponse=mApiService.getTopRatedMovies(MainActivity.API_KEY);
        getMovieResponse.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }


    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onNext(MovieResponse movieResponse) {
        List<Movie> movies=movieResponse.getResults();
        mMainView.onResonseRecieved(movies);
    }
}
