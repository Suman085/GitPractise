package com.example.user.retrofitting.di.modules;

import android.content.Context;

import com.google.gson.Gson;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by User on 3/28/2017.
 */
@Module
public class ApplicationModule {
    private Context context;
    private String baseUrl;

    public ApplicationModule(Context context,String baseUrl){
        this.context=context;
        this.baseUrl=baseUrl;
    }


    @Provides
    @Singleton
    Context providesContext(){
        return context;
    }

    @Provides
    @Singleton
    OkHttpClient mOkHttpClient(){
        return new OkHttpClient.Builder().build();
    }
    @Provides
    @Singleton
    OkHttp3Downloader mOkHttp3Downloader(OkHttpClient okHttpClient){
        return new OkHttp3Downloader(okHttpClient);
    }
    @Singleton
    @Provides
    Picasso providesPicasso(Context context, OkHttp3Downloader okHttp3Downloader){
        return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .indicatorsEnabled(true)
                .build();
    }

    @Singleton
    @Provides
    GsonConverterFactory providesGson(){
        return GsonConverterFactory.create();
    }
    @Singleton
    @Provides
    RxJavaCallAdapterFactory providesCallAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }
    @Singleton
    @Provides
    Retrofit providesRetrofit(OkHttpClient okHttpClient, GsonConverterFactory gson,RxJavaCallAdapterFactory callAdapterFactory){
        return new Retrofit.Builder().client(okHttpClient)
                .addConverterFactory(gson)
                .addCallAdapterFactory(callAdapterFactory)
                .baseUrl(baseUrl)
                .build();
    }

}
