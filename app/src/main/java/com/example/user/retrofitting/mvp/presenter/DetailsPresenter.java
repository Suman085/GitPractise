package com.example.user.retrofitting.mvp.presenter;

import android.util.Log;

import com.example.user.retrofitting.Api.ApiInterface;
import com.example.user.retrofitting.mvp.model.MovieDetails;
import com.example.user.retrofitting.mvp.view.DetailsView;
import com.example.user.retrofitting.ui.activities.MainActivity;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by User on 3/28/2017.
 */
public class DetailsPresenter implements IDetailsPresenter, Observer<MovieDetails>{

    @Inject
    DetailsView mDetailsView;
    @Inject
    ApiInterface mApiInterface;
    private Observable<MovieDetails> movieDetailsObservable;
    private Subscription subscription;

    public static final String TAG=DetailsPresenter.class.getSimpleName();
@Inject
public DetailsPresenter(){

}

    @Override
    public void getMovieDetails(int movie_id) {
       movieDetailsObservable= mApiInterface.getMovieDetails(movie_id, MainActivity.API_KEY);
         subscription=movieDetailsObservable.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this);
    }


    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG,e.getMessage());
    }

    @Override
    public void onNext(MovieDetails movieDetails) {
        mDetailsView.onResponse(movieDetails);
    }

    public void onStop() {
        subscription.unsubscribe();
    }
}
