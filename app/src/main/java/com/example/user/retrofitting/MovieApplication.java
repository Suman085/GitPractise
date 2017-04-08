package com.example.user.retrofitting;

import android.app.Application;

import com.example.user.retrofitting.di.component.ApplicationComponent;
import com.example.user.retrofitting.di.component.DaggerApplicationComponent;
import com.example.user.retrofitting.di.modules.ApplicationModule;

/**
 * Created by User on 3/28/2017.
 */

public class MovieApplication extends Application {
    private ApplicationComponent mApplicationComponent;
    private String baseUrl="https://api.themoviedb.org/3/";
    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent=DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this,baseUrl))
                .build();

    }
    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
