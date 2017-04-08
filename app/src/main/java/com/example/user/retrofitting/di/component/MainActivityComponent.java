package com.example.user.retrofitting.di.component;

import com.example.user.retrofitting.di.modules.MainActivityModule;
import com.example.user.retrofitting.di.scope.PerActivity;
import com.example.user.retrofitting.ui.activities.MainActivity;

import dagger.Component;

/**
 * Created by User on 3/28/2017.
 */

@PerActivity
@Component(modules = MainActivityModule.class ,dependencies = ApplicationComponent.class)
public interface MainActivityComponent {
    void inject(MainActivity mainActivity);
}
