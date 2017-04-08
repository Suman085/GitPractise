package com.example.user.retrofitting.di.modules;

import com.example.user.retrofitting.Api.ApiInterface;
import com.example.user.retrofitting.di.scope.PerActivity;
import com.example.user.retrofitting.mvp.view.MainView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by User on 3/28/2017.
 */
@Module
public class MainActivityModule {

        private MainView mMainView;
    public MainActivityModule (MainView mainView){
        this.mMainView=mainView;
    }
    @Provides
    @PerActivity
    ApiInterface providesApiInterface(Retrofit retrofit){
        return retrofit.create(ApiInterface.class);
    }
    @Provides
    @PerActivity
    MainView providesMainView(){
        return mMainView;
    }


}

