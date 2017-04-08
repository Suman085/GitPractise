package com.example.user.retrofitting.di.component;

import android.content.Context;

import com.example.user.retrofitting.di.modules.ApplicationModule;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by User on 3/28/2017.
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    Retrofit exposeRetrofit();
    Picasso exposePicasso();
    Context exposeContext();
}
