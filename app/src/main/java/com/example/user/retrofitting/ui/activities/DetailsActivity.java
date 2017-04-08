package com.example.user.retrofitting.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.retrofitting.MovieApplication;
import com.example.user.retrofitting.R;
import com.example.user.retrofitting.di.component.DaggerDetailsActivityComponent;
import com.example.user.retrofitting.di.modules.DetailsActivityModule;
import com.example.user.retrofitting.mvp.model.MovieDetails;
import com.example.user.retrofitting.mvp.presenter.DetailsPresenter;
import com.example.user.retrofitting.mvp.view.DetailsView;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

public class DetailsActivity extends AppCompatActivity implements DetailsView{
    public static final String TAG=DetailsActivity.class.getSimpleName();
    @Inject
    DetailsPresenter mDetailsPresenter;
    @Inject
    Picasso mPicasso;
    private TextView mTitleView;
    private ImageView mPosterImage;
    private TextView mReleaseDate;
    private TextView mOverview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
       int movie_id = getIntent().getIntExtra("movie_id",0);
        resolveDaggerDependencies();
        mTitleView = (TextView) findViewById(R.id.title_of_movie);
        mReleaseDate=(TextView)findViewById(R.id.date_release);
        mPosterImage=(ImageView)findViewById(R.id.poster_image_movie_details);
        mOverview=(TextView)findViewById(R.id.over_view);
        mDetailsPresenter.getMovieDetails(movie_id);

    }

    private void resolveDaggerDependencies() {
        DaggerDetailsActivityComponent.builder().applicationComponent(((MovieApplication)getApplication()).getApplicationComponent())
                .detailsActivityModule(new DetailsActivityModule(this))
                .build().inject(this);
    }

    @Override
    public void onResponse(MovieDetails movieDetails) {
        mTitleView.setText(movieDetails.getTitle());
        mReleaseDate.setText(movieDetails.getReleaseDate());
        mOverview.setText(movieDetails.getOverview());
        Log.e(TAG,movieDetails.getPosterPath());
                mPicasso.load("https://image.tmdb.org/t/p/w150"+movieDetails.getPosterPath()).fit().into(mPosterImage);
    }

    @Override
    protected void onStop() {
        super.onStop();
    mDetailsPresenter.onStop();
    }
}
