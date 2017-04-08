package com.example.user.retrofitting.ui.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.retrofitting.Adapter.MovieAdapter;
import com.example.user.retrofitting.Api.ApiInterface;
import com.example.user.retrofitting.MovieApplication;
import com.example.user.retrofitting.R;
import com.example.user.retrofitting.di.component.DaggerMainActivityComponent;
import com.example.user.retrofitting.di.modules.MainActivityModule;
import com.example.user.retrofitting.mvp.model.Movie;
import com.example.user.retrofitting.mvp.model.MovieResponse;
import com.example.user.retrofitting.mvp.presenter.MainPresenter;
import com.example.user.retrofitting.mvp.view.MainView;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements MainView{


    @Inject
    MainPresenter mPresenter;

    private RecyclerView mRecyclerView;
    public static final String API_KEY="94469e203dc2ce54cb0ab7f4b01259cc";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        resolveDaggerDependency();
        mPresenter.getResponse();
    }

    private void resolveDaggerDependency() {
        DaggerMainActivityComponent.builder().applicationComponent(((MovieApplication)getApplication()).getApplicationComponent())
                .mainActivityModule(new MainActivityModule(this)).build().inject(this);
    }

    @Override
    public void onResonseRecieved(List<Movie> movies) {
        mRecyclerView.setAdapter(new MovieAdapter(movies,R.layout.movie_row,MainActivity.this));
    }
}
