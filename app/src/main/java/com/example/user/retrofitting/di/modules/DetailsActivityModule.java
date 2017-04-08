package com.example.user.retrofitting.di.modules;

import com.example.user.retrofitting.Api.ApiInterface;
import com.example.user.retrofitting.di.scope.PerActivity;
import com.example.user.retrofitting.mvp.view.DetailsView;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by User on 3/28/2017.
 */

@Module
public class DetailsActivityModule {

    private DetailsView mDetailsView;

    public DetailsActivityModule (DetailsView mDetailsView){
        this.mDetailsView=mDetailsView;
    }
    @Provides
    @PerActivity
    DetailsView providesDetailsView(){
        return mDetailsView;
    }

    @Provides
    @PerActivity
    ApiInterface providesApiInterface(Retrofit retrofit){
        return retrofit.create(ApiInterface.class);
    }
}
