package com.example.user.retrofitting.di.component;

import com.example.user.retrofitting.Api.ApiInterface;
import com.example.user.retrofitting.di.modules.DetailsActivityModule;
import com.example.user.retrofitting.di.scope.PerActivity;
import com.example.user.retrofitting.mvp.view.DetailsView;
import com.example.user.retrofitting.ui.activities.DetailsActivity;

import dagger.Component;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by User on 3/28/2017.
 */
@PerActivity
@Component(modules = DetailsActivityModule.class,dependencies = ApplicationComponent.class)
public interface DetailsActivityComponent {
  void inject(DetailsActivity detailsActivity);

}
